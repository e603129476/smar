package com.huaxun.smart.entity.system;

import javax.persistence.*;

/**
 * 系统角色表
 * 
 * @desc 自动生成代码
 * @date 2015/10/22
 */

@Entity
@Table(name = "sys_role")
public class SysRole {

	private Integer id; // 主键
	private String name; // 角色名称 eg:管理员
	private String description; // 角色描述 eg:管理系统

	public SysRole(){

	}

	public SysRole(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", length = 11, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME", length = 64, nullable = false)
	public String getName() {
		return this.name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "DESCRIPTION", length = 128)
	public String getDescription() {
		return this.description;
	}


}