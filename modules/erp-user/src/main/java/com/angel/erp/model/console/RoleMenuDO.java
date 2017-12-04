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
 * @date: 2017年12月4日 下午2:01:27
 * @author li_ming 
 */
@Table(name = "role_menu")
public class RoleMenuDO {
	@Id
	@Column(name = "role_id")
	private String roleId;

	@Id
	@Column(name = "menu_id")
	private String menuId;

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

	/**
	 * @return menu_id
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
}
