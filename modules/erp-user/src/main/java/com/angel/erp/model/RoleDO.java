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
 * @date: 2017年12月3日 下午10:01:46
 * @author li_ming 
 */
@Table(name = "wh_role")
public class RoleDO {
	@Id
	@Column(name = "role_id")
	private Integer roleId;

	private String role;

	@Column(name = "parent_id")
	private Integer parentId;

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
	 * @return role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role == null ? null : role.trim();
	}

	/**
	 * @return parent_id
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
