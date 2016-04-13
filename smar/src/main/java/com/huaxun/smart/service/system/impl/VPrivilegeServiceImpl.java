package com.huaxun.smart.service.system.impl;

import com.huaxun.smart.entity.system.VPrivilege;
import com.huaxun.smart.repository.system.VPrivilegeRepository;
import com.huaxun.smart.service.system.VPrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *资源表
 */
 
@Service("vPrivilege")
public class VPrivilegeServiceImpl implements VPrivilegeService {

	@Resource
	private VPrivilegeRepository vPrivilegeRepository;

	public VPrivilege add(VPrivilege entity){
		return vPrivilegeRepository.save(entity);
	}
	public void delete(Integer id){
		vPrivilegeRepository.delete(id);
	}
	public VPrivilege update(VPrivilege entity){
		return vPrivilegeRepository.save(entity);
	}
	public VPrivilege findOne(Integer id){
		return vPrivilegeRepository.findOne(id);
	}
	public List<VPrivilege> queryAll(){
		return vPrivilegeRepository.findAll();
	}
	public List<VPrivilege> queryPrivilegeByResourceId(Integer resourceId)
	{
		return vPrivilegeRepository.queryPrivilegeByResourceId(resourceId);
	}
}