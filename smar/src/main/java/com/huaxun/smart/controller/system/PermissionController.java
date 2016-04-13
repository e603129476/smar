package com.huaxun.smart.controller.system;

import com.huaxun.smart.entity.system.VUserPrivilege;
import com.huaxun.smart.service.system.VUserPrivilegeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinsx on 2016/01/21.
 */
@Controller
@RequestMapping("sys")
public class PermissionController {

    @Resource
    VUserPrivilegeService vUserPrivilegeService;

    @RequestMapping(value = "perms")
    @ResponseBody
    public void queryPerms(HttpServletRequest request,HttpServletResponse response)throws IOException{
        response.setContentType("text/plain;charset=UTF-8");
//        AuthUser user = (AuthUser)SecurityUtils.getSubject().getPrincipal();
//        List<VUserPrivilege> privilegeList = user.getPrivileges();
//        List<VUserPrivilege> privilegeList =vUserPrivilegeService.queryPrivilegeByUserId(user.getId()) ;
//        Long count=new Long(privilegeList.size());
//        if(privilegeList.get(0)==null){
//            count=Long.valueOf(0);
//            privilegeList=new ArrayList<>();
//        }
//        responseToClient(response,count,AppConst.GSON.toJson(privilegeList));
    }

    @RequestMapping(value = "permsByResource")
    @ResponseBody
    public void queryPermsByResource(HttpServletRequest request,HttpServletResponse response)throws IOException{
//        response.setContentType("text/plain;charset=UTF-8");
//        AuthUser user = (AuthUser)SecurityUtils.getSubject().getPrincipal();
//
//        Integer resourceId=Integer.valueOf(request.getParameter("resourceId"));
//        List<VUserPrivilege> privilegeList =vUserPrivilegeService.queryPrivilegeByUserIdAndResource(user.getId(),resourceId) ;
//        Long count=new Long(privilegeList.size());
//        if(privilegeList.get(0)==null){
//            count=Long.valueOf(0);
//            privilegeList=new ArrayList<>();
//        }
//        responseToClient(response,count,AppConst.GSON.toJson(privilegeList));

    }

    private void responseToClient(HttpServletResponse response, Long total, String json) throws IOException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"total\":" + total + ",\"rows\":");
        buffer.append(json);
        buffer.append("}");
        response.getWriter().write(buffer.toString());
    }
}
