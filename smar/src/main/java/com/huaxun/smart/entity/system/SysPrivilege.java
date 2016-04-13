package com.huaxun.smart.entity.system;

import javax.persistence.*;

/**
 * 权限表
 * 
 * @desc 自动生成代码
 * @date 2015/10/22
 */

@Entity
@Table(name = "sys_privilege")
public class SysPrivilege {

	private Integer id; // 主键
	private Integer parentid; // 父ID
	private String name; // 权限名称
	private String code; // 权限编码
	private String resourcename; // 资源名称
	private String resourcecode; // 资源编码
	private String resourceuri; // 资源URI
	private Integer resourcetype; // 资源类型(1菜单 2页面 3url)
	private Integer rank; // 排序号
	private String actionname; // 动作名称
	private String actioncode; // 动作编码
	public SysPrivilege() {
	}

	public SysPrivilege(Integer id, Integer parentid, String name, String code, String resourcename, String resourcecode, String resourceuri, Integer resourcetype, Integer rank, String actionname, String actioncode) {
		this.id = id;
		this.parentid = parentid;
		this.name = name;
		this.code = code;
		this.resourcename = resourcename;
		this.resourcecode = resourcecode;
		this.resourceuri = resourceuri;
		this.resourcetype = resourcetype;
		this.rank = rank;
		this.actionname = actionname;
		this.actioncode = actioncode;
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

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	@Column(name = "PARENTID", length = 11)
	public Integer getParentid() {
		return this.parentid;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NAME", length = 32)
	public String getName() {
		return this.name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "CODE", length = 16)
	public String getCode() {
		return this.code;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	@Column(name = "RESOURCENAME", length = 128)
	public String getResourcename() {
		return this.resourcename;
	}

	public void setResourcecode(String resourcecode) {
		this.resourcecode = resourcecode;
	}

	@Column(name = "RESOURCECODE", length = 16)
	public String getResourcecode() {
		return this.resourcecode;
	}

	public void setResourceuri(String resourceuri) {
		this.resourceuri = resourceuri;
	}

	@Column(name = "RESOURCEURI", length = 128)
	public String getResourceuri() {
		return this.resourceuri;
	}

	public void setResourcetype(Integer resourcetype) {
		this.resourcetype = resourcetype;
	}

	@Column(name = "RESOURCETYPE", length = 11)
	public Integer getResourcetype() {
		return this.resourcetype;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Column(name = "RANK", length = 11)
	public Integer getRank() {
		return this.rank;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	@Column(name = "ACTIONNAME", length = 32)
	public String getActionname() {
		return this.actionname;
	}

	public void setActioncode(String actioncode) {
		this.actioncode = actioncode;
	}

	@Column(name = "ACTIONCODE", length = 16)
	public String getActioncode() {
		return this.actioncode;
	}

}