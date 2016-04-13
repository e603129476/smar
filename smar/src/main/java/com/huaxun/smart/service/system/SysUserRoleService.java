package com.huaxun.smart.service.system;

import com.huaxun.smart.entity.system.SysUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 *用户表
 *@desc 自动生成代码
 *@date 2015/10/22
 */
 
public interface SysUserRoleService {

	public SysUserRole add(SysUserRole entity);
	public void delete(Integer id);
	public SysUserRole update(SysUserRole entity);
	public SysUserRole findOne(Integer id);
	public List<SysUserRole> queryAll();
	public Page<SysUserRole> queryAll(Pageable page);
	public List<SysUserRole> queryAll(Sort sort);

	/**
	 * 根据userId删除该用户关联的角色
	 * @param userId
	 */
	public void deleteRoleByUserId(Integer userId);

	public List<SysUserRole> queryRoleByUserId(Integer userId);
}