/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.model.console;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午1:39:09
 * @author li_ming 
 */
public class AdminDO implements Serializable {
	private static final long serialVersionUID = -8109920541941658889L;

	@Id
	@Column(name = "uid")
	@GeneratedValue(generator = "UUID")
	private String uid;

	@NotEmpty(message = "账号不能为空")
	private String username;

	private String password;

	private String salt;

	private Integer state;

	private Integer isSystem;

	private String createdAt;

	private String updatedAt;

	@Transient
	@JsonIgnore
	private String sort = "";

	@Transient
	@JsonIgnore
	private String order = "";

	@Transient
	private String[] roleId;

	@Transient
	private List<RoleDO> roleList;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(Integer isSystem) {
		this.isSystem = isSystem;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getSort() {
		if (StringUtils.isEmpty(sort)) {
			return "createdAt";
		} else {
			return sort;
		}
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		if (StringUtils.isEmpty(sort)) {
			return "desc";
		} else {
			return order;
		}
	}

	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 密码盐.
	 * @return
	 */
	public String getCredentialsSalt() {
		return this.username + this.salt;
	}

	public String[] getRoleId() {
		return roleId;
	}

	public void setRoleId(String[] roleId) {
		this.roleId = roleId;
	}

	public List<RoleDO> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleDO> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "Admin{" + "uid='" + uid + '\'' + ", username='" + username + '\'' + ", password='" + password + '\''
				+ ", salt='" + salt + '\'' + ", state=" + state + ", createdAt='" + createdAt + '\'' + ", updatedAt='"
				+ updatedAt + '\'' + ", sort='" + sort + '\'' + ", order='" + order + '\'' + ", roleList=" + roleList
				+ '}';
	}

}