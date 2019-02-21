package com.demo.spring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Utility class to encode db pwds, not part of application

public class MyPwdEncoder {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("welcome1"));
	}
}
