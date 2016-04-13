package com.huaxun.smart.entity.system;

import java.io.Serializable;


public class VUserPrivilegePK implements Serializable {
	private Integer userId;
	private Integer roleId;
	private Integer privilegeId;
	private Integer resourceId;
	private Integer actionId;

	public VUserPrivilegePK()
	{}
	public VUserPrivilegePK(Integer userId, Integer roleId,Integer privilegeId,Integer resourceId, Integer actionId
	) {
		this.userId = userId;
		this.roleId=roleId;
		this.privilegeId=privilegeId;
		this.resourceId = resourceId;
		this.actionId = actionId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return this.userId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getRoleId() {
		return this.roleId;
	}

	public Integer getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public Integer getActionId() {
		return actionId;
	}
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		VUserPrivilegePK that = (VUserPrivilegePK) o;

		if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
		if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
		if (resourceId != null ? !resourceId.equals(that.resourceId) : that.resourceId != null) return false;
		return !(actionId != null ? !actionId.equals(that.actionId) : that.actionId != null);

	}

	@Override
	public int hashCode() {
		int result = userId != null ? userId.hashCode() : 0;
		result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
		result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
		result = 31 * result + (actionId != null ? actionId.hashCode() : 0);
		return result;
	}

}