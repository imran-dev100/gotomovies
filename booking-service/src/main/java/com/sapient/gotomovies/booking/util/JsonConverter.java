package com.sapient.gotomovies.booking.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonConverter {

	@Autowired
	private ObjectMapper objectMapper;

	private final TypeReference<Map<String, String>> typeReference = new TypeReference<Map<String, String>>() {
	};

	private final TypeReference<Map<String, Object>> mapObjectTypeReference = new TypeReference<Map<String, Object>>() {
	};

	public Map<String, String> convertJsonStringToMap(String jsonString) throws JsonProcessingException {
		return objectMapper.readValue(jsonString, typeReference);
	}

	public Map<String, Object> convertJsonStringToMapOfObject(String jsonString) throws JsonProcessingException {
		return objectMapper.readValue(jsonString, mapObjectTypeReference);
	}

	public String convertObjectToJsonString(Object object) throws JsonProcessingException {
		return objectMapper.writeValueAsString(object);
	}

	public <T> T convertJsonStringToObject(String jsonString, Class<T> clazz) throws JsonProcessingException {
		return objectMapper.readValue(jsonString, clazz);
	}
}
