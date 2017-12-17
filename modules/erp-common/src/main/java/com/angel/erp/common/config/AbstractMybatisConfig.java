/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.config;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Mybatis配置
 *
 * @date: 2017年12月16日 上午11:45:07
 * @author li_ming 
 */
public abstract class AbstractMybatisConfig {

	//@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		//		dataSource.setDriverClassName(env.getProperty("source.driverClassName").trim());
		//		dataSource.setUrl(env.getProperty("source.url").trim());
		//		dataSource.setUsername(env.getProperty("source.username").trim());
		//		dataSource.setPassword(env.getProperty("source.password").trim());
		return dataSource;
	}

	//@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
}
