package com.huaxun.smart.service.system;

import com.huaxun.smart.entity.system.SysResourcePrivilege;

import java.util.List;

/**
 *资源表
 *@desc 自动生成代码
 */
 
public interface SysResourcePrivilegeService {
	public SysResourcePrivilege add(SysResourcePrivilege entity);
	public void delete(Integer id);
	public SysResourcePrivilege update(SysResourcePrivilege entity);
	public SysResourcePrivilege findOne(Integer id);
	public List<SysResourcePrivilege> queryAll();

	public void deleteByResourceId(Integer id);

	public List<SysResourcePrivilege> queryByResourceId(Integer resourceid);
}