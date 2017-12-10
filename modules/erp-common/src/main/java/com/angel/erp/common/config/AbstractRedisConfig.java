/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.config;

import java.nio.charset.Charset;

import org.apache.commons.lang3.SerializationException;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Redis配置
 *
 * @date: 2017年12月9日 下午11:09:28
 * @author li_ming 
 */
public abstract class AbstractRedisConfig extends CachingConfigurerSupport {

	@Bean
	@SuppressWarnings("rawtypes")
	public RedisSerializer fastJson2JsonRedisSerializer() {
		return new FastJson2JsonRedisSerializer<Object>(Object.class);
	}

	/**
	 * 定义Redis模板  
	 *
	 * @param connectionFactory
	 * @return 
	 */
	@Bean
	@SuppressWarnings("rawtypes")
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory,
			RedisSerializer fastJson2JsonRedisSerializer) {
		StringRedisTemplate template = new StringRedisTemplate(connectionFactory);
		template.setValueSerializer(fastJson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate<String, String> redisTemplate) {
		RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
		//设置缓存过期时间(秒)
		redisCacheManager.setDefaultExpiration(1800);
		return redisCacheManager;
	}

	public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {

		private Class<T> clazz;

		public FastJson2JsonRedisSerializer(Class<T> clazz) {
			super();
			this.clazz = clazz;
		}

		public byte[] serialize(T t) throws SerializationException {
			if (t == null) {
				return new byte[0];
			}
			return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(Charset.forName("UTF-8"));
		}

		public T deserialize(byte[] bytes) throws SerializationException {
			if (bytes == null || bytes.length <= 0) {
				return null;
			}
			String str = new String(bytes, Charset.forName("UTF-8"));
			return (T) JSON.parseObject(str, clazz);
		}
	}
}
