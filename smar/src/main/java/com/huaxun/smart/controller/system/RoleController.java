package com.huaxun.smart.controller.system;

import com.huaxun.smart.entity.system.SysResource;
import com.huaxun.smart.entity.system.SysRole;
import com.huaxun.smart.entity.system.SysRolePrivilege;
import com.huaxun.smart.entity.system.VPrivilege;
import com.huaxun.smart.service.system.SysResourceService;
import com.huaxun.smart.service.system.SysRolePrivilegeService;
import com.huaxun.smart.service.system.SysRoleService;
import com.huaxun.smart.service.system.VPrivilegeService;
import com.huaxun.smart.utils.JsonUtil;
import com.huaxun.smart.utils.PrivilegeTreeNode;
import com.huaxun.smart.utils.ReturnMsg;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyingdong on 2015.10.28.
 * Update by lingking 2015.12.11
 */

@Controller
@RequestMapping(value = "role")
public class RoleController {
    @Resource
    private SysRoleService roleService;
    @Resource
    private SysRolePrivilegeService rolePrivilegeService;
    @Resource
    private SysResourceService sysResourceService;
    @Resource
    private VPrivilegeService vPrivilegeService;
    @RequestMapping("index")
    public ModelAndView index()throws IOException {
        ModelAndView mv = new ModelAndView("system/role");
        return mv;
    }
    @RequestMapping(value="getRoles",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String getRoles(HttpServletRequest request,HttpServletResponse response)
    {
        List<SysRole> roles=roleService.queryAll();
        return JsonUtil.ojectArrayToJson(roles);
    }

    @RequestMapping(value="getRolesByPage",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String getRolesByPage(HttpServletRequest request,HttpServletResponse response)
    {
        String sEcho=request.getParameter("sEcho");
        int pageNumber=Integer.parseInt(request.getParameter("iDisplayStart"));
        int pagzSize=Integer.parseInt(request.getParameter("iDisplayLength"));
        Page<SysRole> roles=roleService.queryAll(new PageRequest(pageNumber/pagzSize,pagzSize));

        long count=roles.getTotalElements();
        String result="{\"sEcho\":"+sEcho+",\"iTotalRecords\":"+count+",\"iTotalDisplayRecords\":"+count+",\"aaData\":"+JsonUtil.ojectArrayToJson(roles.getContent())+"}";
        return result;
    }
    @RequestMapping("deleteRole")
    @ResponseBody
    public String  deleteRole(HttpServletRequest request, HttpServletResponse response) {
       String roleStr=request.getParameter("roleId");
       roleService.delete(Integer.valueOf(roleStr));
        ReturnMsg result= new ReturnMsg(true,"","角色删除成功！");
        return JsonUtil.beanToJson(result);
    }

    @RequestMapping("createRole")
    @ResponseBody
    public String  createRole(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String roleStr=request.getParameter("role");
        SysRole role=JsonUtil.jsonToBean(roleStr,SysRole.class);
        SysRole result=roleService.add(role);
        return JsonUtil.beanToJson(result);
    }

    @RequestMapping(value="updateRole",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String  updateRole(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String roleStr=request.getParameter("role");
        SysRole role=JsonUtil.jsonToBean(roleStr,SysRole.class);
        SysRole result =roleService.update(role);
//        casRealmOA.clearAllCachedAuthorizationInfoManual();
        return JsonUtil.beanToJson(result);
    }

    @RequestMapping(value="allocatePrivilege",method = RequestMethod.POST)
    @ResponseBody
    public String  allocatePrivilege(HttpServletRequest request,HttpServletResponse response)
    {
        String roleStr=request.getParameter("roleId");
        Integer roleId=Integer.valueOf(roleStr);
        roleService.deleteRolePrivilege(roleId);

        String privilegesStr=request.getParameter("privileges");
        JSONArray privileges=JSONArray.fromObject(privilegesStr);

        for(int i=0;i<privileges.size();i++)
        {
            JSONObject obj=(JSONObject)privileges.get(i);
            SysRolePrivilege privilege=new SysRolePrivilege();
            privilege.setRoleid(roleId);
            privilege.setPrivilegeid(Integer.valueOf(obj.getString("privilegeId")));
            rolePrivilegeService.add(privilege);

        }
//        casRealmOA.clearAllCachedAuthorizationInfoManual();
        ReturnMsg result= new ReturnMsg(true,"","权限分配成功！");
        return JsonUtil.beanToJson(result);
    }

    //获取资源权限树形数据
    @RequestMapping(value = "getPrivilege",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String getPrivilege(HttpServletRequest request,HttpServletResponse response)
    {
        List<SysResource> resources=sysResourceService.queryAll();
        List<PrivilegeTreeNode> result=new ArrayList<>();

        Integer id=1000000;
        for (SysResource resource: resources
             ) {
            PrivilegeTreeNode resourceNode=new PrivilegeTreeNode();
            Integer resourceId=resource.getId();
            resourceNode.setId(resourceId);
            resourceNode.setPrivilegeId(Integer.valueOf("0"));
            resourceNode.setActionId(null);
            resourceNode.setResourceId(resourceId);
            resourceNode.setActionName("");
            resourceNode.setLeaf(false);
            resourceNode.setResourceName(resource.getResourceName());
            resourceNode.setParentId(resource.getParentId());
            resourceNode.setTitle(resource.getResourceName());
            result.add(resourceNode);

            List<VPrivilege> vPrivileges=vPrivilegeService.queryPrivilegeByResourceId(resourceId);
            Integer parentId=Integer.valueOf(resourceId);
            for (VPrivilege privilege:vPrivileges
                 ) {
                id++;
                PrivilegeTreeNode privilegeNode=new PrivilegeTreeNode();
                privilegeNode.setId(id);
                privilegeNode.setPrivilegeId(privilege.getId());
                privilegeNode.setActionId(privilege.getActionId());
                privilegeNode.setResourceId(resourceId);
                privilegeNode.setActionName(privilege.getActionName());
                privilegeNode.setLeaf(true);
                privilegeNode.setResourceName(privilege.getResourceName());
                privilegeNode.setParentId(parentId);
                privilegeNode.setTitle(privilege.getActionName());
                result.add(privilegeNode);
            }
            id++;
        }
        return JsonUtil.beanToJson(result);
    }

    //根据角色获取权限
    @RequestMapping(value = "getPrivilegeByRole",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String getPrivilegeByRole(HttpServletRequest request,HttpServletResponse response)
    {
        String roleStr=request.getParameter("roleId");
        Integer roleId=Integer.valueOf(roleStr);
        List<SysRolePrivilege> rolePrivileges=rolePrivilegeService.queryByRoleId(roleId);
        return JsonUtil.beanToJson(rolePrivileges);
    }
}
