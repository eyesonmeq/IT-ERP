/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午1:34:21
 * @author li_ming 
 */
public class CustomerAuthenticationToken extends UsernamePasswordToken {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private String captcha;
	/**
	 * 用来区分前后台登录的标记
	 */
	private String loginType;
	/**
	 * 用来区分登录用户的渠道
	 */
	private String loginForm;

	public CustomerAuthenticationToken(String username, String password, boolean rememberMe) {
		super(username, password, rememberMe);
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(String loginForm) {
		this.loginForm = loginForm;
	}
}
