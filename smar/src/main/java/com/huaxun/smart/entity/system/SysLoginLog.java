package com.huaxun.smart.entity.system;// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysLoginlog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_loginlog")
public class SysLoginLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String account;
	private Timestamp loginTime;
	private String loginIp;

	// Constructors

	/** default constructor */
	public SysLoginLog() {
	}

	/** minimal constructor */
	public SysLoginLog(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	/** full constructor */
	public SysLoginLog(Integer userId, String account, Timestamp loginTime,
			String loginIp) {
		this.userId = userId;
		this.account = account;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
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

	@Column(name = "userid")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "account", length = 20)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "logintime", nullable = false, length = 19)
	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "loginip", length = 40)
	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

}