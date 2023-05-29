package com.wiley.springcore;

public class StudentAddress {
	private String address;

	public StudentAddress(String address) {
		super();
		this.address = address;
	}

	public StudentAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentAddress [address=" + address + "]";
	}
	
	
}
