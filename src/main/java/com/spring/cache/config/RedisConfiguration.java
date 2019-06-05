package com.spring.cache.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.cache.model.StudentSerializer;

@Configuration
public class RedisConfiguration {

	@Bean
	@Primary
	public RedisCacheConfiguration defaultCacheConfig(ObjectMapper objectMapper) {
		return RedisCacheConfiguration.defaultCacheConfig()
				.serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(SerializationPair.fromSerializer(new StudentSerializer()));
		// .serializeValuesWith(SerializationPair.fromSerializer(new
		// GenericJackson2JsonRedisSerializer(objectMapper)));
	}

	
	 @Bean
	    public CacheManager cacheManager() {

	      return new ConcurrentMapCacheManager() {

	        @Override
	        protected Cache createConcurrentMapCache(String name) {
	          return new ConcurrentMapCollectionHandlingDecoratedCache(super.createConcurrentMapCache(name));
	        }
	      };
	    }
	

	
}
