package com.spring.cache.config;

import java.util.concurrent.Callable;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;

public class RedisCustomCache extends RedisCache {

	protected RedisCustomCache(String name, RedisCacheWriter cacheWriter, RedisCacheConfiguration cacheConfig) {
		super(name, cacheWriter, cacheConfig);
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized <T> T get(Object key, Callable<T> valueLoader) {
		// TODO Auto-generated method stub
		return super.get(key, valueLoader);
	}

	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		super.put(key, value);
	}

}
