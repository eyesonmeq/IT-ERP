/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import com.angel.erp.common.config.AbstractRedisConfig;

/**
 * Redis配置
 *
 * @date: 2017年12月9日 下午11:09:28
 * @author li_ming 
 */
@Configuration
@EnableCaching
public class RedisConfig extends AbstractRedisConfig {}
