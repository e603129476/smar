package com.huaxun.smart.entity.system;// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_log")
public class SysLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String account;
	private String module;
	private String methods;
	private Timestamp actionTime;
	private String userIp;
	private Timestamp operTime;
	private String description;

	// Constructors

	/** default constructor */
	public SysLog() {
	}

	/** full constructor */
	public SysLog(String account, String module, String methods,
				  Timestamp actionTime, String userIp, Timestamp operTime,
			String description) {
		this.account = account;
		this.module = module;
		this.methods = methods;
		this.actionTime = actionTime;
		this.userIp = userIp;
		this.operTime = operTime;
		this.description = description;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "account", length = 30)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "module", length = 30)
	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Column(name = "methods", length = 30)
	public String getMethods() {
		return this.methods;
	}

	public void setMethods(String methods) {
		this.methods = methods;
	}

	@Column(name = "actiontime", length = 30)
	public Timestamp getActionTime() {
		return this.actionTime;
	}

	public void setActionTime(Timestamp actionTime) {
		this.actionTime = actionTime;
	}

	@Column(name = "userip", length = 30)
	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	@Column(name = "opertime", length = 19)
	public Timestamp getOperTime() {
		return this.operTime;
	}

	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}

	@Column(name = "description", length = 5000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}