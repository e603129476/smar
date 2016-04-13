package com.huaxun.smart.repository.system;

import com.huaxun.smart.entity.system.SysPrivilege;
import com.huaxun.smart.entity.system.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * 系统角色表
 * 
 * @desc 自动生成代码
 * @date 2015/10/22
 */

public interface SysRoleRepository extends JpaRepository<SysRole, Integer>,
		JpaSpecificationExecutor<SysRole> {

	@Query("select p from SysPrivilege p,SysRolePrivilege rp where p.id = rp.privilegeid and rp.roleid = ?1")
	Set<SysPrivilege> getPrivileges(Integer roleId);

	@Modifying
	@Transactional
	@Query(value = "delete from sys_role_privilege where ROLEID=?1",nativeQuery = true)
	void deleteRolePrivilege(Integer roleId);
	@Query("select r from SysRole r,SysUserRole ur where r.id.id = ur.roleid and ur.userid = ?1")
	List<SysRole> getUserRoles(Integer id);

}