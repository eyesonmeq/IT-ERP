/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午1:31:10
 * @author li_ming 
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
	@Override
	public void setLoginUrl(String loginUrl) {
		super.setLoginUrl("/member/login");
	}

	@Override
	public void setSuccessUrl(String successUrl) {
		super.setSuccessUrl("/member/index");
	}
}
