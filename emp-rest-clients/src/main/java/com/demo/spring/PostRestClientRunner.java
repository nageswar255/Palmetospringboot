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

@Component
public class PostRestClientRunner implements CommandLineRunner {

	@Autowired
	RestTemplate rt;

	@Override
	public void run(String... args) throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", MediaType.TEXT_PLAIN_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		Emp e = new Emp(111, "Saty", "Hyd", 90000);

		HttpEntity req = new HttpEntity<>(e, headers);

		ResponseEntity<String> resp = rt.exchange("http://localhost:8383/emp/save", HttpMethod.POST, req, String.class);

		System.out.println(resp.getBody());
		
		//-----------------------------
		
		

	}

}
