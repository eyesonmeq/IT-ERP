/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.service.common;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * ADD FUNCTION
 *
 * @date: 2017年12月4日 下午2:47:15
 * @author li_ming 
 */
@Service
public interface RedisService {
	public Jedis getResource();

	public void returnResource(Jedis jedis);

	public void set(String key, String value);

	public String get(String key);
}
