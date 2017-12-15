package com.angel.erp.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色权限关系
 *
 * @date: 2017年12月15日 下午11:56:37
 * @author li_ming 
 */
@Table(name = "role_permission_link")
public class RolePermissionLinkDO {

	/**
	 * 角色主键
	 */
	@Id
	@Column(name = "role_id")
	private Long roleId;

	/**
	 * 权限主键
	 */
	@Id
	@Column(name = "permission_id")
	private Long permissionId;

	/**
	 * 获取角色主键
	 *
	 * @return role_id - 角色主键
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 设置角色主键
	 *
	 * @param roleId 角色主键
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取权限主键
	 *
	 * @return permission_id - 权限主键
	 */
	public Long getPermissionId() {
		return permissionId;
	}

	/**
	 * 设置权限主键
	 *
	 * @param permissionId 权限主键
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
}