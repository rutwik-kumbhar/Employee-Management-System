package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	
	private final  JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authProvider;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		
		
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement()
		.autheticationProvider()
		.ad
		
		
		return http.build();
	}

}
