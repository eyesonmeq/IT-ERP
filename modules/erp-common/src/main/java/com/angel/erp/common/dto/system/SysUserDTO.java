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

	private static final long serialVersionUID = -7535143086026356454L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 创建时间
	 */
	private String gmtCreate;
	/**
	 * 变更时间
	 */
	private String gmtModified;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户昵称
	 */
	private String nickname;
	/**
	 * 密码
	 */
	private String userPassword;
	/**
	 * 用户状态（1：正常，2：停用，3：锁定）
	 */
	private Short userState;
	/**
	 * 盐
	 */
	private String salt;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the gmtCreate
	 */
	public String getGmtCreate() {
		return gmtCreate;
	}

	/**
	 * @param gmtCreate the gmtCreate to set
	 */
	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	/**
	 * @return the gmtModified
	 */
	public String getGmtModified() {
		return gmtModified;
	}

	/**
	 * @param gmtModified the gmtModified to set
	 */
	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the userState
	 */
	public Short getUserState() {
		return userState;
	}

	/**
	 * @param userState the userState to set
	 */
	public void setUserState(Short userState) {
		this.userState = userState;
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

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}
}
