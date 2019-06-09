package com.spring.cache.config;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;

public class CustomRedisCacheManager extends RedisCacheManager {

	private RedisCacheWriter cacheWriter;
	private RedisCacheConfiguration defaultCacheConfiguration;

	public CustomRedisCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {
		super(cacheWriter, defaultCacheConfiguration);
		this.cacheWriter = cacheWriter;
		this.defaultCacheConfiguration = defaultCacheConfiguration;
	}

	/*
	 * @Override protected Collection<RedisCache> loadCaches() { // TODO
	 * Auto-generated method stub return super.loadCaches(); }
	 */

	@Override
	protected RedisCache createRedisCache(String name, RedisCacheConfiguration cacheConfig) {
		return new CustomRedisCache(name, cacheWriter, cacheConfig != null ? cacheConfig : defaultCacheConfiguration);
	}

}
