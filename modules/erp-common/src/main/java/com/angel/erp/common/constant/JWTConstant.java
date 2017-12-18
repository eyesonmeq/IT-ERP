/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.constant;

/**
 * JWT相关常量
 *
 * @date: 2017年12月11日 下午1:26:35
 * @author li_ming 
 */
public class JWTConstant {
	/**
	 * 类型
	 */ 
	public static final String TYPE = "type";
	/**
	 * 密码
	 */ 
	public static final String USER_PASSWORD = "user_password";
	/**
	 * 帐号
	 */ 
	public static final String USER_ACCOUNT = "user_account";
	
	/**
	 * 客户端ID
	 */ 
	public static final String JWT_CLIENT_ID = "323f6bcd4621d342cade1e7345227b4f6";
	/**
	 * 名称
	 */ 
	public static final String JWT_NAME = "restapi";
	/**
	 * 密钥
	 */ 
	public static final String JWT_BASE64_SECRET = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY";
	/**
	 * 超时时间
	 */ 
	public static final int JWT_EXPIRES_SECOND = 172800;
	
	/**
	 * 请求参数名称
	 */ 
	public static final String AUTHORIZATION = "Authorization";
	/**
	 * 请求头token标识 
	 */ 
	public static final String TOKENHEAD = "bearer";
}
