/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.config;

import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.angel.erp.common.config.AbstractShiroConfig;

/**
 * Shiro 配置
 *
 * @date: 2017年12月4日 下午1:35:20
 * @author li_ming 
 */
@Configuration
public class ShiroConfig extends AbstractShiroConfig {

	/* 
	 * @see com.angel.erp.common.config.AbstractShiroConfig#getFilterRuleMap()
	 */
	@Override
	public Map<String, String> getFilterRuleMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
