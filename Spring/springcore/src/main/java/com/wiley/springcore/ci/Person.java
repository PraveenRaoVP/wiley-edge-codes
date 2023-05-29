package com.wiley.springcore.ci;

public class Person {
	private int id;
	private String name;
	private Cert cert;
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name +", Cert="+this.cert.name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Person() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	public Person(int id, String name, Cert cert) {
		super();
		this.id = id;
		this.name = name;
		this.cert = cert;
	}
	
}
