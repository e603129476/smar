package com.huaxun.smart.entity.system;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 资源表
 */

@Entity
@Table(name = "sys_resource")
public class SysResource implements Serializable {
	private Integer id;
	private String resourceCode;
	private String resourceName;
	private Integer resourceType;
	private Integer parentId;
	private String description;
	public SysResource()
	{}
	public SysResource(Integer id, String resourceCode, String resourceName, Integer resourceType, Integer parentId, String description) {
		this.id = id;
		this.resourceCode = resourceCode;
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.parentId = parentId;
		this.description = description;
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

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}