package com.wiley.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages="com.wiley.springcore.config")
public class SpringConfig {
	@Bean
	public Beer getBeer() {
		Beer beer = new Beer();
		return beer;
	}
	
	@Bean
	public Student getStudent() {
		Student student= new Student();
		return student;
	}
}