package com.huaxun.smart.service.system.impl;

import com.huaxun.smart.entity.system.SysUserRole;
import com.huaxun.smart.repository.system.SysUserRoleRepository;
import com.huaxun.smart.service.system.SysUserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *用户表
 *@desc 自动生成代码
 *@date 2015/10/22
 */
 
@Service("userRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Resource
	private SysUserRoleRepository userRoleRepository;

	public SysUserRole add(SysUserRole entity){
		return userRoleRepository.save(entity);
	}
	public void delete(Integer id){
		userRoleRepository.delete(id);
	}
	public SysUserRole update(SysUserRole entity){
		return userRoleRepository.save(entity);
	}
	public SysUserRole findOne(Integer id){
		return userRoleRepository.findOne(id);
	}
	public List<SysUserRole> queryAll(){
		return userRoleRepository.findAll();
	}
	
	public Page<SysUserRole> queryAll(Pageable page){
		return userRoleRepository.findAll(page);
	}

	public List<SysUserRole> queryAll(Sort sort){
		return userRoleRepository.findAll(sort);
	}

	@Override
	public void deleteRoleByUserId(Integer userId) {
		userRoleRepository.deleteRoleByUserId(userId);
	}

	public List<SysUserRole> queryRoleByUserId(Integer userId){
		return userRoleRepository.queryRoleByUserId(userId);
	}
}