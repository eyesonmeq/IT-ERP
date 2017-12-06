/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.mybatis;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.github.pagehelper.PageHelper;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * MyBatis基础配置
 *
 * @date: 2017年12月4日 上午11:16:10
 * @author li_ming 
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {

	@Resource
	public DataSource dataSource;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setTypeAliasesPackage("com.angel.erp.model");

		//分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
		properties.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
		properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);

		//添加插件
		bean.setPlugins(new Interceptor[] { pageHelper });

		//添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
			bean.setMapperLocations(resolver.getResources("classpath:mapper/*/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.angel.erp.mapper");
		Properties properties = new Properties();
		properties.setProperty("mappers", "com.angel.erp.common.mybatis.CustomerMapper");
		properties.setProperty("notEmpty", "false");
		properties.setProperty("IDENTITY", "MYSQL");
		mapperScannerConfigurer.setProperties(properties);
		return mapperScannerConfigurer;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}
}
