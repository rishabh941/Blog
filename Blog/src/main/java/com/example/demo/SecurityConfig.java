package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeHttpRequests(
				auth ->auth
				.requestMatchers("/blogs").permitAll()
				.anyRequest().authenticated())
				.oauth2Login(auth-> auth.defaultSuccessUrl("/blogs"))
				.csrf().disable();
				return httpSecurity.build();
				
	}
}
