package com.huaxun.smart.entity.system;

import javax.persistence.*;

/**
 * 用户角色表
 * 
 * @desc 自动生成代码
 * @date 2015/10/22
 */

@Entity
@Table(name = "sys_user_role")
public class SysUserRole {

	private Integer id; // 主键
	private Integer roleid; // 角色ID
	private Integer userid; // 用户ID

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", length = 11, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Column(name = "ROLEID", length = 11, nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "USERID", length = 11)
	public Integer getUserid() {
		return this.userid;
	}

}