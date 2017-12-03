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
 * @date: 2017年12月3日 下午10:00:16
 * @author li_ming 
 */
@Table(name = "wh_permission")
public class PermissionDO {
	@Id
	@Column(name = "permission_id")
	private Integer permissionId;

	private String permission;

	private String name;

	/**
	 * @return permission_id
	 */
	public Integer getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId
	 */
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 * @return permission
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * @param permission
	 */
	public void setPermission(String permission) {
		this.permission = permission == null ? null : permission.trim();
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
}
