package com.huaxun.smart.repository.system;

import com.huaxun.smart.entity.system.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户角色表
 * 
 * @desc 自动生成代码
 * @date 2015/10/22
 */

public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Integer>,
		JpaSpecificationExecutor<SysUserRole> {

	@Transactional
	@Modifying
	@Query(value="delete from sys_user_role where USERID=?1",nativeQuery = true)
	public void deleteRoleByUserId(Integer userId);

	@Query("select u from SysUserRole u where userid=?1")
	public List<SysUserRole> queryRoleByUserId(Integer userId);

}