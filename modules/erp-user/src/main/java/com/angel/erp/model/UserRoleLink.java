/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月3日 下午10:03:28
 * @author li_ming 
 */
@Table(name = "wh_user_role_link")
public class UserRoleLink {
	@Id
	@Column(name = "role_id")
	private Integer roleId;

	@Id
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * @return role_id
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return user_id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
