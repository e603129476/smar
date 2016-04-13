package com.huaxun.smart.service.system.impl;

import com.huaxun.smart.entity.system.SysResourcePrivilege;
import com.huaxun.smart.repository.system.SysResourcePrivilegeRepository;
import com.huaxun.smart.service.system.SysResourcePrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *资源表
 */
 
@Service("sysResourcePrivilegeService")
public class SysResourcePrivilegeServiceImpl implements SysResourcePrivilegeService {

	@Resource
	private SysResourcePrivilegeRepository sysResourcePrivilegeRepository;

	public SysResourcePrivilege add(SysResourcePrivilege entity){
		return sysResourcePrivilegeRepository.save(entity);
	}
	public void delete(Integer id){
		sysResourcePrivilegeRepository.delete(id);
	}
	public SysResourcePrivilege update(SysResourcePrivilege entity){
		return sysResourcePrivilegeRepository.save(entity);
	}
	public SysResourcePrivilege findOne(Integer id){
		return sysResourcePrivilegeRepository.findOne(id);
	}
	public List<SysResourcePrivilege> queryAll(){
		return sysResourcePrivilegeRepository.findAll();
	}

	public void deleteByResourceId(Integer id){
		sysResourcePrivilegeRepository.deleteByResourceId(id);
	}

	public List<SysResourcePrivilege> queryByResourceId(Integer resourceid)
	{
		return sysResourcePrivilegeRepository.queryByResourceId(resourceid);
	}
}