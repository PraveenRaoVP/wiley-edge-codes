package com.wiley.springcore.foobar.carexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCar {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/wiley/springcore/foobar/carexample/config.xml");
		CarService cs = context.getBean("carService", CarService.class);
		cs.displayCarDetails();
	}
}
