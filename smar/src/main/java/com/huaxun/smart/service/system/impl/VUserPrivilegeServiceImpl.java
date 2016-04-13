package com.huaxun.smart.service.system.impl;

import com.huaxun.smart.entity.system.VUserPrivilege;
import com.huaxun.smart.repository.system.VUserPrivilegeRepository;
import com.huaxun.smart.service.system.VUserPrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *资源表
 */
 
@Service("vUserPrivilege")
public class VUserPrivilegeServiceImpl implements VUserPrivilegeService {

	@Resource
	private VUserPrivilegeRepository vUserPrivilegeRepository;

	public List<VUserPrivilege> queryAll(){
		return vUserPrivilegeRepository.findAll();
	}
	public List<VUserPrivilege> queryPrivilegeByUserId(Integer userId)
	{
		return vUserPrivilegeRepository.queryPrivilegeByUserId(userId);
	}

	public List<VUserPrivilege> queryPrivilegeByUserIdAndResource(Integer userId, Integer resourceId)
	{
		return vUserPrivilegeRepository.queryPrivilegeByUserIdAndResource(userId,resourceId);
	}
}