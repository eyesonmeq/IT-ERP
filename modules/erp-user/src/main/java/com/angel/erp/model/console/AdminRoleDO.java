/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.model.console;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午1:44:03
 * @author li_ming 
 */
@Table(name = "admin_role")
public class AdminRoleDO {
	@Id
	@Column(name = "admin_id")
	private String adminId;

	@Id
	@Column(name = "role_id")
	private String roleId;

	/**
	 * @return admin_id
	 */
	public String getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return role_id
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
