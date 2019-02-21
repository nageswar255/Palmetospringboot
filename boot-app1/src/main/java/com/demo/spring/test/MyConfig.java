package com.demo.spring.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	
	@Bean
	public String hello() {
		return "hello";
	}

	@Bean
	public String bye() {
		return "bye bye";
	}
}
