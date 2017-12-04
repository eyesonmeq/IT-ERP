/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 上午11:13:58
 * @author li_ming 
 */
@Configuration
public class ErrorPageConfig {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
		return new MyCustomizer();
	}

	private static class MyCustomizer implements EmbeddedServletContainerCustomizer {
		@Override
		public void customize(ConfigurableEmbeddedServletContainer container) {
			container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
		}
	}
}
