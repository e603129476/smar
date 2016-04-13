package com.huaxun.smart.service.system;


import com.huaxun.smart.entity.system.VUserPrivilege;

import java.util.List;

/**
 *资源表
 *@desc 自动生成代码
 */
 
public interface VUserPrivilegeService {

	public List<VUserPrivilege> queryAll();
	public List<VUserPrivilege> queryPrivilegeByUserId(Integer userId);
	public List<VUserPrivilege> queryPrivilegeByUserIdAndResource(Integer userId, Integer resourceId);
}