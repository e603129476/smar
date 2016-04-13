package com.huaxun.smart.service.system;

import com.huaxun.smart.entity.system.SysPrivilege;
import com.huaxun.smart.entity.system.SysRole;
import com.huaxun.smart.entity.system.SysRolePrivilege;
import com.huaxun.smart.entity.system.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Created by zhangyingdong on 2015.10.28.
 */
public interface SysRoleService {

    public SysRole add(SysRole entity);
    public SysRole save(SysRole entity);
    public void delete(Integer id);
    public SysRole update(SysRole entity);
    public SysRole findOne(Integer id);
    public List<SysRole> queryAll();
    public Page<SysRole> queryAll(Pageable page);
    public Page<SysRole> queryAll(Specification<SysRole> spec, Pageable page);
    public List<SysRole> queryAll(Sort sort);
    public List<SysRole> queryAll(Specification<SysRole> spec);

    /**
     * 获取所有权限定义信息
     * @return ListPrivilege
     */
    public List<SysPrivilege> getPrivileges();

    /**
     * 根据角色id获取其已分配的权限信息
     * @param roleId
     * @return ListPrivilege
     */
    public List<SysPrivilege> getPrivileges(Integer roleId);

    /**
     * 根据角色ID，删除该角色已分配的权限
     * @param roleId
     */
    public void deleteRolePrivilege(Integer roleId);

    /**
     * 保存角色权限对应关系
     * @param rolePrivilege
     * @return
     */
    public SysRolePrivilege saveRolePrivilege(SysRolePrivilege rolePrivilege);

    public List<SysRole> getUserRoles(Integer id);

}
