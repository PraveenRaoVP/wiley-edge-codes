package com.wiley.springcore.reftype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/wiley/springcore/reftype/configref.xml");
		WileyA wileyA  = (WileyA) context.getBean("waref");
		System.out.println(wileyA.getOb().getCount());
	}
}
