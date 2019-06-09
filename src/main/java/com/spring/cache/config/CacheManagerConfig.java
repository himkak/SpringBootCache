package com.spring.cache.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.spring.cache.model.StudentSerializer;

@Configuration
@EnableCaching
public class CacheManagerConfig {

	@Autowired
	LettuceConnectionFactory connfactory;

	@Bean("redisCacheManager")
	public CacheManager redisCacheManager() {
		RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofMinutes(5)).disableCachingNullValues()
				.serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()))
				 .serializeValuesWith(SerializationPair.fromSerializer(new
				 StudentSerializer()));
				//.serializeValuesWith(RedisSerializationContext.SerializationPair
					//	.fromSerializer(new GenericJackson2JsonRedisSerializer()));
		
		
		CustomRedisCacheWriter redisCacheWriter=new CustomRedisCacheWriter(connfactory);
		
		return  new CustomRedisCacheManager(redisCacheWriter, cacheConfiguration);
		
		//return RedisCacheManagerBuilder.fromCacheWriter(redisCacheWriter).cacheDefaults(cacheConfiguration).build();

	}

}
