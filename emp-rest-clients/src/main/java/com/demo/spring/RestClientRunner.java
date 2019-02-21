package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

//@Component
public class RestClientRunner implements CommandLineRunner {

	@Autowired
	RestTemplate rt;
	
	@Override
	public void run(String... args) throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity req = new HttpEntity<>(headers);
		
		System.out.println("In Client..");
		
		ResponseEntity<String> resp = rt.exchange("http://localhost:8383/emp/find/101", HttpMethod.GET, req, String.class);
		
		System.out.println(resp.getBody());
		
		ResponseEntity<Emp> resp2 = rt.exchange("http://localhost:8383/emp/find/101", HttpMethod.GET, req, Emp.class);
		
		System.out.println(resp2.getBody());
	}

}
