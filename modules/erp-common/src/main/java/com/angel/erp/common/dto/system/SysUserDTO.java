/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.dto.system;

import java.io.Serializable;

import com.angel.erp.common.util.JsonUtil;

/**
 * 系统用户
 *
 * @date: 2017年12月9日 下午9:59:33
 * @author li_ming 
 */
public class SysUserDTO implements Serializable {

	// (用一句话描述这个变量表示什么). 
	private static final long serialVersionUID = -7535143086026356454L;
	// 账户
	private String account;
	// 姓名
	private String name;
	// 密码
	private String password;
	// 状态
	private Short state;
	// 盐
	private String salt;
	// 创建时间
	private String createTime;

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the state
	 */
	public Short getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Short state) {
		this.state = state;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
}
