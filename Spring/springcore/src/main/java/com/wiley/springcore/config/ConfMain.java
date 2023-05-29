package com.wiley.springcore.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext con= new AnnotationConfigApplicationContext(SpringConfig.class);
		Student student=con.getBean("getStudent", Student.class);
		System.out.println(student);
		student.study();
		student.getBeer().drinks();;
		

	}

}