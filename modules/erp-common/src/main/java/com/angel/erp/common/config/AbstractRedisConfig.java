/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis配置
 *
 * @date: 2017年12月9日 下午11:09:28
 * @author li_ming 
 */
public abstract class AbstractRedisConfig extends CachingConfigurerSupport {
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate<String, String> redisTemplate) {
		RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
		//设置缓存过期时间(秒)
		redisCacheManager.setDefaultExpiration(1800);
		return redisCacheManager;
	}
}
