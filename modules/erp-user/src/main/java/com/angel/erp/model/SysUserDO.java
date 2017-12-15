package com.angel.erp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.angel.erp.common.util.JsonUtil;

/**
 * 系统用户
 *
 * @date: 2017年12月15日 下午11:54:24
 * @author li_ming 
 */
@Table(name = "sys_user")
public class SysUserDO implements Serializable {
	private static final long serialVersionUID = 8500968401115848516L;

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 创建时间
	 */
	@Column(name = "gmt_create")
	private Date gmtCreate;

	/**
	 * 变更时间
	 */
	@Column(name = "gmt_modified")
	private Date gmtModified;

	/**
	 * 用户名
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * 用户昵称
	 */
	@NotBlank
	@Size(min = 1, max = 50)
	@Pattern(regexp = "^[a-zA-Z_][\\w]{4,19}$", message = "{user.name.pattern.error}")
	private String nickname;

	/**
	 * 密码
	 */
	@Column(name = "user_password")
	private String userPassword;

	/**
	 * 用户状态（1：正常，2：停用，3：锁定）
	 */
	@Column(name = "user_state")
	private Byte userState;

	/**
	 * 盐
	 */
	private String salt;

	/**
	 * 获取主键
	 *
	 * @return id - 主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置主键
	 *
	 * @param id 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取创建时间
	 *
	 * @return gmt_create - 创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * 设置创建时间
	 *
	 * @param gmtCreate 创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * 获取变更时间
	 *
	 * @return gmt_modified - 变更时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}

	/**
	 * 设置变更时间
	 *
	 * @param gmtModified 变更时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * 获取用户名
	 *
	 * @return user_name - 用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名
	 *
	 * @param userName 用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取用户昵称
	 *
	 * @return nickname - 用户昵称
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * 设置用户昵称
	 *
	 * @param nickname 用户昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 获取密码
	 *
	 * @return user_password - 密码
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * 设置密码
	 *
	 * @param userPassword 密码
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * 获取用户状态（1：正常，2：停用，3：锁定）
	 *
	 * @return user_state - 用户状态（1：正常，2：停用，3：锁定）
	 */
	public Byte getUserState() {
		return userState;
	}

	/**
	 * 设置用户状态（1：正常，2：停用，3：锁定）
	 *
	 * @param userState 用户状态（1：正常，2：停用，3：锁定）
	 */
	public void setUserState(Byte userState) {
		this.userState = userState;
	}

	/**
	 * 获取盐
	 *
	 * @return salt - 盐
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * 设置盐
	 *
	 * @param salt 盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

	/* 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gmtCreate == null) ? 0 : gmtCreate.hashCode());
		result = prime * result + ((gmtModified == null) ? 0 : gmtModified.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/* 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysUserDO other = (SysUserDO) obj;
		if (gmtCreate == null) {
			if (other.gmtCreate != null)
				return false;
		} else if (!gmtCreate.equals(other.gmtCreate))
			return false;
		if (gmtModified == null) {
			if (other.gmtModified != null)
				return false;
		} else if (!gmtModified.equals(other.gmtModified))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}