package com.huaxun.smart.service.system;

import com.huaxun.smart.entity.system.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *用户表
 *@desc 自动生成代码
 *@date 2015/10/22
 */
 
public interface SysUserService {
	public SysUser add(SysUser entity);
	public void delete(Integer id);
	public SysUser update(SysUser entity);
	public SysUser findOne(Integer id);
	public List<SysUser> findAll();
	public Page<SysUser> findAll(Pageable page);

	public SysUser findByAccount(String accout);
	public Page<SysUser> getAllUserByConditionAndPage(String condition,Pageable pageable);
}
