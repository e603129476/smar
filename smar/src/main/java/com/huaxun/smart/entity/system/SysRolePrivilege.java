package com.huaxun.smart.entity.system;

import javax.persistence.*;

/**
 * 系统角色权限表
 * 
 * @desc 自动生成代码
 * @date 2015/10/22
 */

@Entity
@Table(name = "sys_role_privilege")
public class SysRolePrivilege {

	private Integer id; // 主键

	private Integer roleid; // 角色ID

	private Integer privilegeid; // 权限ID

	public SysRolePrivilege() {
	}

	public SysRolePrivilege(Integer id, Integer roleid, Integer privilegeid) {
		this.id = id;
		this.roleid = roleid;
		this.privilegeid = privilegeid;
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

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Column(name = "ROLEID", length = 11, nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setPrivilegeid(Integer privilegeid) {
		this.privilegeid = privilegeid;
	}

	@Column(name = "PRIVILEGEID", length = 11)
	public Integer getPrivilegeid() {
		return this.privilegeid;
	}

}