package com.huaxun.smart.service.system.impl;

import com.huaxun.smart.entity.system.SysResource;
import com.huaxun.smart.repository.system.SysResourceRepository;
import com.huaxun.smart.service.system.SysResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *资源表
 */
 
@Service("sysResourceService")
public class SysResourceServiceImpl implements SysResourceService {

	@Resource
	private SysResourceRepository sysResourceRepository;

	public SysResource add(SysResource entity){
		return sysResourceRepository.save(entity);
	}
	public void delete(Integer id){
		sysResourceRepository.delete(id);
	}
	public SysResource update(SysResource entity){
		return sysResourceRepository.save(entity);
	}
	public SysResource findOne(Integer id){
		return sysResourceRepository.findOne(id);
	}
	public List<SysResource> queryAll(){
		return sysResourceRepository.findAll();
	}
}