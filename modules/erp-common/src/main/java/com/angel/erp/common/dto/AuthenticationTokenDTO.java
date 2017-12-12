/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.dto;

import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * jwt token
 *
 * @date: 2017年12月11日 下午1:19:26
 * @author li_ming 
 */
public class AuthenticationTokenDTO implements AuthenticationToken {

	private static final long serialVersionUID = 825350124292222768L;
	// jwt token
	private String token;
	// 用户身份即用户名
	private String userName;
	// 凭证
	private String auth;
	// 角色
	private List<String> roles;
	// 权限
	private Set<String> permission;

	/* 
	 * @see org.apache.shiro.authc.AuthenticationToken#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return auth;
	}

	/* 
	 * @see org.apache.shiro.authc.AuthenticationToken#getPrincipal()
	 */
	@Override
	public Object getPrincipal() {
		return userName;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
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
	 * @return the auth
	 */
	public String getAuth() {
		return auth;
	}

	/**
	 * @param auth the auth to set
	 */
	public void setAuth(String auth) {
		this.auth = auth;
	}

	/**
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	/**
	 * @return the permission
	 */
	public Set<String> getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(Set<String> permission) {
		this.permission = permission;
	}
}
