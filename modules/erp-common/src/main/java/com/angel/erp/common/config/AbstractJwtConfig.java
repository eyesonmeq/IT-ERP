/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 注册jwt认证过滤器 
 *
 * @date: 2017年12月10日 下午10:03:48
 * @author li_ming 
 */
public abstract class AbstractJwtConfig {
	/**
	 * 注册过滤器类和过滤的url 
	 *
	 * @return 
	 */
	@Bean
	public FilterRegistrationBean basicFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		JwtAuthorizeFilter filter = new JwtAuthorizeFilter();
		registrationBean.setFilter(filter);

		List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add("/user/*");

		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
}
