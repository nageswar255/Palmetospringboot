package com.demo.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource ds;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/emp/**")
		.hasAnyRole("USER","CLIENT")
		.antMatchers("/info**")
		.authenticated()
		.and()
		.httpBasic()
		.and()
		.csrf()
		.disable();
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
/*
 * Commented to implement creds fetch from DB
 * 
 * 	@Autowired //Autowire here forces method to execute n spring injects authmgr. cannot be bean as returns void.
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication().withUser("sri").roles("USER").password(encoder().encode("welcome1"));
		auth.inMemoryAuthentication().withUser("srik").roles("CLIENT").password(encoder().encode("welcome1"));
		auth.inMemoryAuthentication().withUser("srika").roles("GUEST").password(encoder().encode("welcome1"));
		auth.inMemoryAuthentication().withUser("srikan").roles("MANAGER").password(encoder().encode("welcome1")).disabled(true);
	}*/
	
	@Autowired //Autowire here forces method to execute n spring injects authmgr. cannot be bean as returns void.
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.jdbcAuthentication()
		.dataSource(ds)
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
	}
}
