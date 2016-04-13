package com.huaxun.smart.service.system.impl;

import com.huaxun.smart.entity.system.SysUser;
import com.huaxun.smart.repository.system.SysUserRepository;
import com.huaxun.smart.service.system.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *用户表
 *@desc 自动生成代码
 *@date 2015/10/22
 */
 
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	@Resource
	private  SysUserRepository sysUserRepository;

	public SysUser add(SysUser entity){
		return sysUserRepository.save(entity);
	}
	public void delete(Integer id){
		sysUserRepository.delete(id);
	}
	public SysUser update(SysUser entity){
	return sysUserRepository.saveAndFlush(entity);
	}
	public SysUser findOne(Integer id){
		return sysUserRepository.findOne(id);
	}
	public List<SysUser> findAll(){
		return sysUserRepository.findAll();
	}
	public Page<SysUser> findAll(Pageable page){
		return sysUserRepository.findAll(page);
	}

	public SysUser findByAccount(String accout){
		return sysUserRepository.findByAccount(accout);
	}
	@Override
	public Page<SysUser> getAllUserByConditionAndPage(String condition,Pageable pageable){
		Integer pageBegin=pageable.getPageNumber()*pageable.getPageSize();
		Integer pageEnd=pageable.getPageSize();
		int totalCount=0;
		List<SysUser> users=new ArrayList<>();
		totalCount=sysUserRepository.findByCondition(condition).size();
		users=sysUserRepository.getAllUserByConditionAndPage(condition,pageBegin,pageEnd);
		return new PageImpl<SysUser>(users,pageable,totalCount);
	}
}
