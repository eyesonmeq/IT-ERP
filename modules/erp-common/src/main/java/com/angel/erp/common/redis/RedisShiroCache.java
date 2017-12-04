/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.redis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 上午11:37:11
 * @author li_ming 
 */
public class RedisShiroCache<K, V> implements Cache<K, V> {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private RedisConfiguration redisConfiguration;

	private String cacheKey;
	private RedisTemplate<K, V> redisTemplate;

	public RedisShiroCache(String name, RedisTemplate client, RedisConfiguration redisConfiguration) {
		this.redisConfiguration = redisConfiguration;
		this.cacheKey = this.redisConfiguration.getCachePrefix() + name;
		this.redisTemplate = client;
	}

	@Override
	public V get(K key) throws CacheException {
		redisTemplate.boundValueOps(getCacheKey(key)).expire(redisConfiguration.getCacheTime(), TimeUnit.MINUTES);
		return redisTemplate.boundValueOps(getCacheKey(key)).get();
	}

	@Override
	public V put(K key, V value) throws CacheException {
		V old = get(key);
		redisTemplate.boundValueOps(getCacheKey(key)).set(value);
		return old;
	}

	@Override
	public V remove(K key) throws CacheException {
		V old = get(key);
		redisTemplate.delete(getCacheKey(key));
		return old;
	}

	@Override
	public void clear() throws CacheException {
		redisTemplate.delete(keys());
	}

	@Override
	public int size() {
		return keys().size();
	}

	@Override
	public Set<K> keys() {
		return redisTemplate.keys(getCacheKey("*"));
	}

	@Override
	public Collection<V> values() {
		Set<K> set = keys();
		List<V> list = new ArrayList<>();
		for (K s : set) {
			list.add(get(s));
		}
		return list;
	}

	private K getCacheKey(Object k) {
		return (K) (this.cacheKey + k);
	}
}
