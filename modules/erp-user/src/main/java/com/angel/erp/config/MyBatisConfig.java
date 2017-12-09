/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.angel.erp.common.config.AbstractMyBatisConfig;

/**
 * MyBatis基础配置
 *
 * @date: 2017年12月9日 下午10:30:31
 * @author li_ming 
 */
@Configuration
@EnableTransactionManagement
public class MyBatisConfig extends AbstractMyBatisConfig {

}
