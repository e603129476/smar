package com.huaxun.smart.controller.system;

import com.huaxun.smart.entity.system.SysResource;
import com.huaxun.smart.entity.system.SysResourcePrivilege;
import com.huaxun.smart.service.system.SysResourcePrivilegeService;
import com.huaxun.smart.service.system.SysResourceService;
import com.huaxun.smart.utils.JsonUtil;
import com.huaxun.smart.utils.ReturnMsg;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lingking on 2015.12.10.
 */
@Controller
@RequestMapping(value = {"resource"})
public class ResourceController {
    @Resource
    private SysResourceService sysResourceService;
    @Resource
    private SysResourcePrivilegeService sysResourcePrivilegeService;

    //跳转资源管理页面
    @RequestMapping("index")
    public ModelAndView index()throws IOException {
        ModelAndView mv = new ModelAndView("system/resource");
        return mv;
    }
   //获取所有资源
    @RequestMapping(value = "getResources",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String getResources(HttpServletRequest request,HttpServletResponse response){
        List<SysResource> resources=sysResourceService.queryAll();
        return JsonUtil.ojectArrayToJson(resources);
    }
  //创建资源
    @RequestMapping(value = "createResource",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String createResource(HttpServletRequest request,HttpServletResponse response)
    {
        String jsonStr=request.getParameter("resource");
        SysResource resource=JsonUtil.jsonToBean(jsonStr,SysResource.class);
        sysResourceService.add(resource);

        ReturnMsg returnMsg=new ReturnMsg(true,"","保存成功!");
        return JsonUtil.beanToJson(returnMsg);
    }
    //删除资源
    @RequestMapping(value = "deleteResource",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String deleteResource(HttpServletRequest request,HttpServletResponse response)
    {
        String id=request.getParameter("id");
        sysResourceService.delete(Integer.valueOf(id));
        ReturnMsg returnMsg=new ReturnMsg(true,"","删除成功!");
        return JsonUtil.beanToJson(returnMsg);
    }
    //修改资源
    @RequestMapping(value = "updateResource",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String updateUser(HttpServletRequest request,HttpServletResponse response)
    {
        String jsonStr=request.getParameter("resource");
        SysResource resource=JsonUtil.jsonToBean(jsonStr,SysResource.class);
        sysResourceService.update(resource);
        ReturnMsg returnMsg=new ReturnMsg(true,"","修改成功!");
        return JsonUtil.beanToJson(returnMsg);
    }
    //给资源定义权限
    @RequestMapping(value = "definePrivilege",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String definePrivilege(HttpServletRequest request,HttpServletResponse response)
    {
        String resourceStr=request.getParameter("resourceId");
        Integer resourceId=Integer.valueOf(resourceStr);
        sysResourcePrivilegeService.deleteByResourceId(resourceId);

        String privilegesStr=request.getParameter("privileges");
        JSONArray privileges=JSONArray.fromObject(privilegesStr);

        for(int i=0;i<privileges.size();i++)
        {
            JSONObject obj=(JSONObject)privileges.get(i);

            SysResourcePrivilege privilege=new SysResourcePrivilege();
            privilege.setResourceId(resourceId);
            privilege.setActionId(Integer.valueOf(obj.getString("privilegeId")));
            sysResourcePrivilegeService.add(privilege);

        }

        ReturnMsg returnMsg=new ReturnMsg(true,"","定义资源权限成功!");
        return JsonUtil.beanToJson(returnMsg);
    }

    //给资源定义权限
    @RequestMapping(value = "getPrivilege",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String getPrivilege(HttpServletRequest request,HttpServletResponse response)
    {
        String resourceStr=request.getParameter("resourceId");
        List<SysResourcePrivilege> privileges=sysResourcePrivilegeService.queryByResourceId(Integer.valueOf(resourceStr));
        return JsonUtil.ojectArrayToJson(privileges);
    }
}
