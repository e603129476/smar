package com.huaxun.smart.entity.system;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 资源权限视图
 */

@Entity
@Table(name = "v_privilege")
public class VPrivilege implements Serializable {
	public VPrivilege(Integer id, Integer resourceId, Integer actionId, String resourceCode, String resourceName, Integer resourceType, Integer parentId, String actionName, String privilegeCode) {
		this.id = id;
		this.resourceId = resourceId;
		this.actionId = actionId;
		this.resourceCode = resourceCode;
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.parentId = parentId;
		this.actionName = actionName;
		this.privilegeCode = privilegeCode;
	}

	private Integer id;
	private Integer resourceId;
	private Integer actionId;
	private String resourceCode;
	private String resourceName;
	private Integer resourceType;
	private Integer parentId;
	private String actionName;
	private String privilegeCode;
	public VPrivilege()
	{}

	public void setId(Integer id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public Integer getId() {
		return this.id;
	}

	@Column(name="resourcecode")
	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	@Column(name="resourcename")
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(name="resourcetype")
	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	@Column(name="parentid")
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	@Column(name = "resourceid")
	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name = "actionid")
	public Integer getActionId() {
		return actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	@Column(name="actionname")
	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Column(name="privilegecode")
	public String getPrivilegeCode() {
		return privilegeCode;
	}

	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}
}