package com.huaxun.smart.service.system;

import com.huaxun.smart.entity.system.SysResource;

import java.util.List;

/**
 *资源表
 *@desc 自动生成代码
 */
 
public interface SysResourceService {

	public SysResource add(SysResource entity);
	public void delete(Integer id);
	public SysResource update(SysResource entity);
	public SysResource findOne(Integer id);
	public List<SysResource> queryAll();
}