package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


@SpringBootApplication
@EnableMongoRepositories(basePackages="com.demo.spring")
public class BootMongoDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMongoDemo1Application.class, args);
	}
	
	@Bean
	public MongoClient mongoClient() {
		
		MongoClient mc = new MongoClient(new ServerAddress("localhost",27017));
		return mc;
	}
	
	/*@Bean
	public MongoTemplate mt() {
		
		MongoTemplate mt = new MongoTemplate(mongoClient(),"test");
		return mt;
	}*/
	
	/*
	 * If this is not given, default template name and database name are same, so will work.
	 * 
	 * public MongoTemplate mongoTemplate() {
		
		MongoTemplate mt = new MongoTemplate(mongoClient(),"test");
		return mt;
	}*/
	
}
