package com.huaxun.smart.controller.system;

import com.huaxun.smart.controller.BaseController;
import com.huaxun.smart.entity.system.SysUser;
import com.huaxun.smart.log.SystemLog;
import com.huaxun.smart.service.system.SysUserService;
import com.huaxun.smart.utils.JsonUtil;
import com.huaxun.smart.utils.Message;
import com.huaxun.smart.utils.PasswordHelper;
import com.huaxun.smart.utils.ReturnData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by lhy on 2016-04-09.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private SysUserService sysUserService;

    @RequiresPermissions("")
    @RequestMapping("index")
    public ModelAndView init() {
        return new ModelAndView("/system/user");
    }

    @RequestMapping(value = "findAllUser", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findAllUser() {
        List<SysUser> userList = sysUserService.findAll();
        return JsonUtil.ojectArrayToJson(userList);
    }

    @RequestMapping(value = "getUsersByConditionAndPage", method = RequestMethod.GET, produces = "text/json;charset=utf-8")
    @ResponseBody
    public String getUsersByConditionAndPage(HttpServletRequest request, HttpServletResponse response) {
        String condition = request.getParameter("condition");
        String sEcho = request.getParameter("sEcho");
        int pageNumber = Integer.parseInt(request.getParameter("iDisplayStart"));
        int pagzSize = Integer.parseInt(request.getParameter("iDisplayLength"));
        Page<SysUser> users = sysUserService.getAllUserByConditionAndPage(condition, new PageRequest(pageNumber / pagzSize, pagzSize));

        List<SysUser> userList = users.getContent();
        long count = users.getTotalElements();
        String result = "{\"sEcho\":" + sEcho + ",\"iTotalRecords\":" + count + ",\"iTotalDisplayRecords\":" + count + ",\"aaData\":" + JsonUtil.ojectArrayToJson(userList) + "}";
        return result;
    }

    @RequestMapping(value = "deleteUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @SystemLog(module = "用户管理",methods = "删除",description = "删除用户")
    public String deleteUser(@RequestParam(value = "userId",required = true) String userId) {
        sysUserService.delete(Integer.valueOf(userId));
        return new ReturnData(Message.SUCCESS, 0).toString();
    }
    @RequestMapping(value = "saveUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @SystemLog(module = "用户管理",methods = "创建",description = "新增用户")
    public String saveUser(HttpServletRequest request) {
        String id=request.getParameter("id");
        String userName=request.getParameter("userName");
        String account=request.getParameter("account");
        String status=request.getParameter("status");
        String description=request.getParameter("description");

        SysUser user;
        SysUser result;
        if("".equals(id))
        {
            PasswordHelper passwordHelper=new PasswordHelper();
            String pass="123";
            Map password= passwordHelper.encryptPassword(account,pass);
            user=new SysUser(userName,account,password.get("password").toString(),password.get("salt").toString(),description,new Timestamp(System.currentTimeMillis()),Integer.valueOf(status));
            result=sysUserService.add(user);
        }
        else
        {
            user=new SysUser(Integer.valueOf(id),userName,account,description,Integer.valueOf(status));
            result=sysUserService.update(user);
        }

        return new ReturnData(Message.SUCCESS, 0,result).toString();
    }
}
