package com.huaxun.smart.entity.system;// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_user")
public class SysUser implements java.io.Serializable {

    // Fields
    private Integer id;
    private String username;
    private String account;
    private String password;
    private String salt;
    private String description;
    private Timestamp createTime;
    private Integer status;

    // Constructors

    /**
     * default constructor
     */
    public SysUser() {
    }

    /**
     * full constructor
     */
    public SysUser(String username, String account, String password,
                   String salt, String description, Timestamp createTime,
                   Integer status) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.salt = salt;
        this.description = description;
        this.createTime = createTime;
        this.status = status;
    }

    public SysUser(Integer id, String username, String account, String description, Integer status) {
        this.id = id;
        this.username = username;
        this.account = account;
        this.description = description;
        this.status = status;
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

    @Column(name = "username", length = 20)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "account", length = 20)
    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "password", length = 100)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "salt", length = 100)
    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Column(name = "description", length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "createtime", length = 19)
    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Column(name = "status")
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}