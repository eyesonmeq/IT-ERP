/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 上午11:22:58
 * @author li_ming 
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
}
