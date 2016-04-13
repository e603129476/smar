package com.huaxun.smart.service.system;


import com.huaxun.smart.entity.system.VPrivilege;

import java.util.List;

/**
 *资源表
 *@desc 自动生成代码
 */
 
public interface VPrivilegeService {

	public VPrivilege add(VPrivilege entity);
	public void delete(Integer id);
	public VPrivilege update(VPrivilege entity);
	public VPrivilege findOne(Integer id);
	public List<VPrivilege> queryAll();
	public List<VPrivilege> queryPrivilegeByResourceId(Integer resourceId);
}