package com.wiley.springcore.misc;

public class SingletonA {
	private static final SingletonA obj = new SingletonA();

	public SingletonA() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("SingletonA obj is created");
	}
	
	//factory method
	public static SingletonA getSingletonA() {
		return obj;
	}
	public void sayHello() {
		System.out.println("Hello");
	}
}
