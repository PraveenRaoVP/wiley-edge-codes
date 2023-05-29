package com.wiley.springcore.autowire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AWMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/wiley/springcore/autowire/annotation/annotationconfig.xml");
		Emp p = context.getBean("emp1", Emp.class);
		//System.out.println(p);
		System.out.println(p.getAddress());
		System.out.println(p.getPhones());
		System.out.println(p.getCourse());
	}
}
