package com.huaxun.smart.entity.system;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 资源权限关系表
 */

@Entity
@Table(name = "sys_resource_privilege")
public class SysResourcePrivilege implements Serializable {
	private Integer id;
	private Integer resourceId;
	private Integer actionId;
	public SysResourcePrivilege()
	{}

	public SysResourcePrivilege(Integer id,Integer resourceId,Integer actionId)
	{
		this.id=id;
		this.resourceId=resourceId;
		this.actionId=actionId;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public Integer getId() {
		return this.id;
	}

	@Column(name="resourceid")
	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name="actionid")
	public Integer getActionId() {
		return this.actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
}