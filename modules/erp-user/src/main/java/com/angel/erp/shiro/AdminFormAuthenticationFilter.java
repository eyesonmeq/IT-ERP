/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 上午11:43:12
 * @author li_ming 
 */
public class AdminFormAuthenticationFilter extends FormAuthenticationFilter {
	@Override
	public void setLoginUrl(String loginUrl) {
		super.setLoginUrl("/console/login");
	}

	@Override
	public void setSuccessUrl(String successUrl) {
		super.setSuccessUrl("/console/index");
	}
}
