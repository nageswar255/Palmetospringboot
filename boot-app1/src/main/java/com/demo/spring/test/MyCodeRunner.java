package com.demo.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Only for quickly testing code like using main method

@Component
@Profile("demo")
@Order(value=2)
public class MyCodeRunner implements CommandLineRunner {

	@Autowired
	@Qualifier("hello")
	String msg;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

}
