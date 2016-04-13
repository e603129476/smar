package com.huaxun.smart.repository.system;

import com.huaxun.smart.entity.system.SysRolePrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 系统角色权限表
 * 
 * @desc 自动生成代码
 * @date 2015/10/22
 */

public interface SysRolePrivilegeRepository extends
		JpaRepository<SysRolePrivilege, Integer>,
		JpaSpecificationExecutor<SysRolePrivilege> {
	@Query("select r from SysRolePrivilege r where r.roleid=?1")
	public List<SysRolePrivilege> queryByRoleId(Integer roleId);

}