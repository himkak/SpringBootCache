package com.spring.cache.model;

import java.io.IOException;
import java.util.List;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentSerializer implements RedisSerializer<Student> {

	@Override
	public byte[] serialize(Student t) throws SerializationException {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			return objMapper.writeValueAsString(t).getBytes();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student deserialize(byte[] bytes) throws SerializationException {
		ObjectMapper objMapper = new ObjectMapper();
		String val = new String(bytes);
		try {
			return objMapper.readValue(bytes, new TypeReference<List<Student>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
