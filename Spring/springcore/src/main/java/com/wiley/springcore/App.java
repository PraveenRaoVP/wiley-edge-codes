package com.wiley.springcore;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Student student1 = (Student)context.getBean("wileystudent1");
		System.out.println(student1);
		System.out.println(student1.getPhones());
        System.out.println(student1.getAddresses());
        System.out.println(student1.getCourses());
        Student student2 = (Student)context.getBean("wileystudent2");
        System.out.println(student2);
	}
}

