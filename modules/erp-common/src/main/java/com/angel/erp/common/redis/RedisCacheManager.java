/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 上午11:28:08
 * @author li_ming 
 */
@Repository("redisCacheManager")
public class RedisCacheManager implements CacheManager {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Resource
	private RedisConfiguration redisConfiguration;

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return new RedisShiroCache<K, V>(name, redisTemplate, redisConfiguration);
	}
}
