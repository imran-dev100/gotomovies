package com.sapient.gotomovies.booking.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Component
public class BeanIntializer {

	@Bean
	RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	
	@PostConstruct
	ObjectMapper createObjectMapper() {
		return new ObjectMapper();
	}
}
