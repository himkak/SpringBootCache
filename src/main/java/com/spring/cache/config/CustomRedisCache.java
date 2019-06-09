package com.spring.cache.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.util.ByteUtils;

public class CustomRedisCache extends RedisCache {

	CustomRedisCacheWriter cacheWriter;
	RedisCacheConfiguration cacheConfig;
	String name;
	
	protected CustomRedisCache(String name, CustomRedisCacheWriter cacheWriter, RedisCacheConfiguration cacheConfig) {
		super(name, cacheWriter, cacheConfig);
		this.cacheWriter=cacheWriter;
		this.name=name;
	}

	@Override
	public void put(Object key, Object value) {
		if(value instanceof Iterable) {
			System.out.println("");
			Iterable<?> values = (Iterable<?>) value;
			List<byte[]> ytesss=new ArrayList<>();
			for(Object valuee:values) {
				super.put(key, valuee);
				ytesss.add(ByteUtils.getBytes(cacheConfig.getValueSerializationPair().write(valuee)));
			}
			cacheWriter.putAll(name, key, cacheConfig.getTtl(), ytesss);
		}else {
			
			super.put(key, value);
		}
	}

	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		return super.putIfAbsent(key, value);
	}

}
