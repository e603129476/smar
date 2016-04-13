package com.huaxun.smart.entity.system;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 资源权限视图
 */

@Entity
@Table(name = "v_user_privilege")
@IdClass(VUserPrivilegePK.class)
public class VUserPrivilege implements Serializable {
	private Integer userId;
	private Integer roleId;
	private Integer privilegeId;
	private Integer resourceId;
	private Integer actionId;
	private String account;

	@Column(name = "username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "account")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	@Column(name = "rolename")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Column(name = "actioncode")
	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	@Column(name = "parentid")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	@Column(name = "actionname")
	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	@Column(name = "privilegecode")
	public String getPrivilegeCode() {
		return privilegeCode;
	}

	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}

	private String userName;
	private String roleName;
	private String resourceCode;
	private String resourceName;
	private Integer resourceType;
	private Integer parentId;
	private String actionCode;
	private String actionName;
	private String privilegeCode;
	public VUserPrivilege()
	{}
@Id
@Column(name = "USERID")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Id
	@Column(name = "ROLEID")
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Id
	@Column(name = "PRIVILEGEID")
	public Integer getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}
	@Id
	@Column(name = "RESOURCEID")
	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public VUserPrivilege(Integer userId, Integer roleId, Integer privilegeId, Integer resourceId, Integer actionId, String account, String userName, String roleName, String resourceCode, String resourceName, Integer resourceType, Integer parentId, String actionCode, String actionName, String privilegeCode) {
		this.userId = userId;
		this.roleId = roleId;
		this.privilegeId = privilegeId;
		this.resourceId = resourceId;
		this.actionId = actionId;
		this.account = account;
		this.userName = userName;
		this.roleName = roleName;
		this.resourceCode = resourceCode;
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.parentId = parentId;
		this.actionCode = actionCode;
		this.actionName = actionName;
		this.privilegeCode = privilegeCode;
	}

	@Id
	@Column(name = "ACTIONID")
	public Integer getActionId() {
		return actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
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


}