package com.huaxun.smart.controller.login;

import com.huaxun.smart.entity.system.SysLoginLog;
import com.huaxun.smart.service.system.SysLoginLogService;
import com.huaxun.smart.utils.ReturnData;
import com.sun.tools.javac.comp.Todo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * Created by lhy on 2016-04-09.
 */
@Controller
@RequestMapping("/")
public class LoginController{
    @Resource
    private SysLoginLogService sysLoginLogService;
    @RequestMapping(value = "login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
    @RequestMapping(value = "index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
    @RequestMapping(value = "userLogin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ModelAndView userLogin(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password, HttpServletRequest request) {
        int code=0;
        String msg="登录成功";

        ModelAndView mv=new ModelAndView();
        try {
            if (!request.getMethod().equals("POST")) {
                 code=-1;
                 msg="为了安全，登录时只支持post提交";
            }

            Subject subject = SecurityUtils.getSubject();
            // 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
            // 认证执行者交由ShiroDbRealm中doGetAuthenticationInfo处理
            // 当以上认证成功后会向下执行,认证失败会抛出异常
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
            } catch (LockedAccountException lae) {
                token.clear();
                code=-1;
                msg="用户已经被锁定不能登录，请与管理员联系！";
            } catch (ExcessiveAttemptsException e) {
                token.clear();
                code=-1;
                msg="账号：" + username + " 登录失败次数过多,锁定10分钟!";
            } catch (AuthenticationException e) {
                token.clear();
                code=-1;
                msg="用户或密码不正确！";
            }
//            写登录日志
            SysLoginLog log=new SysLoginLog();
            log.setAccount(username);
            log.setLoginIp(subject.getSession().getHost());
            log.setLoginTime(new Timestamp(System.currentTimeMillis()));
            log.setUserId(0);
            sysLoginLogService.add(log);

        } catch (Exception e) {
            e.printStackTrace();
            code=-1;
            msg="登录异常，请联系管理员！";
        }
        if(code==0)
        {
          mv.setViewName("index");
        }
        else
        {
            mv.addObject("message",msg);
            mv.setViewName("login");

        }
        return mv;
    }

    @RequestMapping(value = "userLogout")
    public ModelAndView userLogout(HttpServletRequest request){
        Subject subject=SecurityUtils.getSubject();
        if(subject.isAuthenticated())
        {
            String username=subject.getPrincipal().toString();
            subject.logout();
            //            写登出日志
            SysLoginLog log=new SysLoginLog();
            log.setAccount(username);
            log.setLoginIp(subject.getSession().getHost());
            log.setLoginTime(new Timestamp(System.currentTimeMillis()));
            log.setUserId(1);
            sysLoginLogService.add(log);
        }
        return new ModelAndView("login");
    }
}
