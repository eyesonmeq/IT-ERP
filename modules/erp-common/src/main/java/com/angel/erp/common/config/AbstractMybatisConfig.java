/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Mybatis配置
 *
 * @date: 2017年12月16日 上午11:45:07
 * @author li_ming 
 */
public abstract class AbstractMybatisConfig {

	/**
	 * 数据库URL
	 */
	@Value("${spring.datasource.url}")
	private String dbUrl;

	/**
	 * 数据库用户
	 */
	@Value("${spring.datasource.username}")
	private String username;

	/**
	 * 数据库密码
	 */
	@Value("${spring.datasource.password}")
	private String password;

	/**
	 * 链接数据库的驱动
	 */
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	/**
	 * 初始化数据库连接数
	 */
	@Value("${spring.datasource.initialSize}")
	private int initialSize;

	/**
	 * 数据库最小连接数
	 */
	@Value("${spring.datasource.minIdle}")
	private int minIdle;

	/**
	 * 数据库最大连接数
	 */
	@Value("${spring.datasource.maxActive}")
	private int maxActive;

	/**
	 * 配置获取连接等待超时的时间
	 */
	@Value("${spring.datasource.maxWait}")
	private int maxWait;

	/**
	 * 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
	 */
	@Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	/**
	 * 配置一个连接在池中最小生存的时间，单位是毫秒
	 */
	@Value("${spring.datasource.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	/**
	 * 验证sql
	 */
	@Value("${spring.datasource.validationQuery}")
	private String validationQuery;

	/**
	 * 申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效
	 */
	@Value("${spring.datasource.testWhileIdle}")
	private boolean testWhileIdle;

	/**
	 * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
	 */
	@Value("${spring.datasource.testOnBorrow}")
	private boolean testOnBorrow;

	/**
	 * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
	 */
	@Value("${spring.datasource.testOnReturn}")
	private boolean testOnReturn;

	/**
	 * 配置数据库连接池
	 *
	 * @return 
	 */
	@Bean(destroyMethod = "close")
	@Primary //在同样的DataSource中，首先使用被标注的DataSource
	public DataSource dataSource() {
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(dbUrl);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
		datasource.setInitialSize(initialSize);
		datasource.setMinIdle(minIdle);
		datasource.setMaxActive(maxActive);
		datasource.setMaxWait(maxWait);
		datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		datasource.setValidationQuery(validationQuery);
		datasource.setTestWhileIdle(testWhileIdle);
		datasource.setTestOnBorrow(testOnBorrow);
		datasource.setTestOnReturn(testOnReturn);
		return datasource;
	}
}
