package com.huaxun.smart.service.system.impl;

import com.huaxun.smart.entity.system.SysPrivilege;
import com.huaxun.smart.entity.system.SysRole;
import com.huaxun.smart.entity.system.SysRolePrivilege;
import com.huaxun.smart.repository.system.SysPrivilegeRepository;
import com.huaxun.smart.repository.system.SysRolePrivilegeRepository;
import com.huaxun.smart.repository.system.SysRoleRepository;
import com.huaxun.smart.service.system.SysRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangyingdong on 2015.10.28.
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleRepository roleRepository;
    @Resource
    private SysPrivilegeRepository privilegeRepository;
    @Resource
    private SysRolePrivilegeRepository rolePrivilegeRepository;

    @Override
    public SysRole add(SysRole entity) {
        return roleRepository.save(entity);
    }

    @Override
    public SysRole save(SysRole entity) {
        return roleRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        roleRepository.delete(id);
    }

    @Override
    public SysRole update(SysRole entity) {
        return roleRepository.save(entity);
    }

    @Override
    public SysRole findOne(Integer id) {
        return roleRepository.findOne(id);
    }

    @Override
    public List<SysRole> queryAll() {
        return roleRepository.findAll();
    }

    @Override
    public Page<SysRole> queryAll(Pageable page) {
        return roleRepository.findAll(page);
    }

    @Override
    public Page<SysRole> queryAll(Specification<SysRole> spec, Pageable page) {
        return roleRepository.findAll(spec,page);
    }

    @Override
    public List<SysRole> queryAll(Sort sort) {
        return roleRepository.findAll(sort);
    }

    @Override
    public List<SysRole> queryAll(Specification<SysRole> spec) {
        return roleRepository.findAll(spec);
    }

    @Override
    public List<SysPrivilege> getPrivileges() {
        return privilegeRepository.findAll();
    }

    @Override
    public List<SysPrivilege> getPrivileges(Integer roleId) {
        Set<SysPrivilege> privileges = roleRepository.getPrivileges(roleId);
        if(privileges == null)
        {
            return null;
        }
        return new ArrayList<SysPrivilege>(privileges);
    }

    @Override
    public void deleteRolePrivilege(Integer roleId) {
        roleRepository.deleteRolePrivilege(roleId);
    }

    @Override
    public SysRolePrivilege saveRolePrivilege(SysRolePrivilege rolePrivilege) {
        return rolePrivilegeRepository.save(rolePrivilege);
    }

    @Override
    public List<SysRole> getUserRoles(Integer id){
        return roleRepository.getUserRoles(id);
    }
}
