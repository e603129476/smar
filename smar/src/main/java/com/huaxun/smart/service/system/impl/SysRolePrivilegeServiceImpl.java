package com.huaxun.smart.service.system.impl;

import com.huaxun.smart.entity.system.SysRolePrivilege;
import com.huaxun.smart.repository.system.SysRolePrivilegeRepository;
import com.huaxun.smart.service.system.SysRolePrivilegeService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lingking on 2015.10.28.
 */
@Service("rolePrivilegeService")
public class SysRolePrivilegeServiceImpl implements SysRolePrivilegeService {

    @Resource
    private SysRolePrivilegeRepository rolePrivilegeRepository;

    @Override
    public SysRolePrivilege add(SysRolePrivilege entity) {
        return rolePrivilegeRepository.save(entity);
    }

    @Override
    public SysRolePrivilege save(SysRolePrivilege entity) {
        return rolePrivilegeRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        rolePrivilegeRepository.delete(id);
    }

    @Override
    public SysRolePrivilege update(SysRolePrivilege entity) {
        return rolePrivilegeRepository.save(entity);
    }

    @Override
    public SysRolePrivilege findOne(Integer id) {
        return rolePrivilegeRepository.findOne(id);
    }

    @Override
    public List<SysRolePrivilege> queryAll() {
        return rolePrivilegeRepository.findAll();
    }


    @Override
    public List<SysRolePrivilege> queryAll(Sort sort) {
        return rolePrivilegeRepository.findAll(sort);
    }
    public List<SysRolePrivilege> queryByRoleId(Integer roleId){
        return rolePrivilegeRepository.queryByRoleId(roleId);
    }
}
