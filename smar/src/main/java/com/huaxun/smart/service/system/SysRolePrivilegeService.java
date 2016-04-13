package com.huaxun.smart.service.system;

import com.huaxun.smart.entity.system.SysRolePrivilege;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by zhangyingdong on 2015.10.28.
 */
public interface SysRolePrivilegeService {

    public SysRolePrivilege add(SysRolePrivilege entity);
    public SysRolePrivilege save(SysRolePrivilege entity);
    public void delete(Integer id);
    public SysRolePrivilege update(SysRolePrivilege entity);
    public SysRolePrivilege findOne(Integer id);
    public List<SysRolePrivilege> queryAll();
    public List<SysRolePrivilege> queryAll(Sort sort);
    public List<SysRolePrivilege> queryByRoleId(Integer roleId);
}
