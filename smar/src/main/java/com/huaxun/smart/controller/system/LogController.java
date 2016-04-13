package com.huaxun.smart.controller.system;

import com.huaxun.smart.controller.BaseController;
import com.huaxun.smart.entity.system.SysLog;
import com.huaxun.smart.entity.system.SysLoginLog;
import com.huaxun.smart.entity.system.SysUser;
import com.huaxun.smart.log.SystemLog;
import com.huaxun.smart.service.system.SysLogService;
import com.huaxun.smart.service.system.SysLoginLogService;
import com.huaxun.smart.service.system.SysUserService;
import com.huaxun.smart.utils.JsonUtil;
import com.huaxun.smart.utils.Message;
import com.huaxun.smart.utils.PasswordHelper;
import com.huaxun.smart.utils.ReturnData;
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
@RequestMapping("/log")
public class LogController extends BaseController {

    @Resource
    private SysLoginLogService sysLoginLogService;
    @Resource
    private SysLogService sysLogService;
/*
系统登陆日志
 */
    @RequestMapping("indexLog")
    public ModelAndView indexLog() {
        return new ModelAndView("/system/sysLogin");
    }


    @RequestMapping(value = "findAllSysLog", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findAllSysLog() {
        List<SysLog> sysLogs = sysLogService.queryAll();
        return JsonUtil.ojectArrayToJson(sysLogs);
    }

    @RequestMapping(value = "getSysLogByPage", method = RequestMethod.GET, produces = "text/json;charset=utf-8")
    @ResponseBody
    public String getSysLogByPage(HttpServletRequest request, HttpServletResponse response) {
        return getLogs(request,1);
    }


/*
系统操作日志
 */
    @RequestMapping("indexAction")
    public ModelAndView init() {
        return new ModelAndView("/system/sysLog");
    }
    @RequestMapping(value = "findAllSysLoginLog", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findAllSysLoginLog() {
        List<SysLoginLog> logs = sysLoginLogService.queryAll();
        return JsonUtil.ojectArrayToJson(logs);
    }

    @RequestMapping(value = "getSysLoginLogByPage", method = RequestMethod.GET, produces = "text/json;charset=utf-8")
    @ResponseBody
    public String getSysLoginLogByPage(HttpServletRequest request, HttpServletResponse response) {
        return getLogs(request,0);
    }

    public String getLogs(HttpServletRequest request,int flag)
    {
        String result="";
        long count=0;
        String sEcho = request.getParameter("sEcho");
        int pageNumber = Integer.parseInt(request.getParameter("iDisplayStart"));
        int pagzSize = Integer.parseInt(request.getParameter("iDisplayLength"));

        if(flag==0)
        {
            Page<SysLoginLog> sysLoginLogs = sysLoginLogService.queryAll(new PageRequest(pageNumber / pagzSize, pagzSize));
            List<SysLoginLog> loginLogList = sysLoginLogs.getContent();
            count = sysLoginLogs.getTotalElements();
            result = "{\"sEcho\":" + sEcho + ",\"iTotalRecords\":" + count + ",\"iTotalDisplayRecords\":" + count + ",\"aaData\":" + JsonUtil.ojectArrayToJson(loginLogList) + "}";

        }
        else
        {
            Page<SysLog> sysLogs = sysLogService.queryAll(new PageRequest(pageNumber / pagzSize, pagzSize));

            List<SysLog> logList = sysLogs.getContent();
             count = sysLogs.getTotalElements();
             result = "{\"sEcho\":" + sEcho + ",\"iTotalRecords\":" + count + ",\"iTotalDisplayRecords\":" + count + ",\"aaData\":" + JsonUtil.ojectArrayToJson(logList) + "}";
        }
        return result;
    }
}
