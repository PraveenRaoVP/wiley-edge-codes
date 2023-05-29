package com.wiley.springcore.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Emp {
	@Autowired
	@Qualifier("address2")
	private Address address;
	private Phones phones;
	private Courses course;
	public Emp(Address address, Phones phones, Courses course) {
		super();
		this.address = address;
		this.phones = phones;
		this.course = course;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Phones getPhones() {
		return phones;
	}
	public void setPhones(Phones phones) {
		this.phones = phones;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Emp [address=" + address + ", phones=" + phones + ", course=" + course + "]";
	}	
}
