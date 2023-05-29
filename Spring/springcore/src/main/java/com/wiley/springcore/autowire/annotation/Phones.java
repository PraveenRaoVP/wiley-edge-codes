package com.wiley.springcore.autowire.annotation;

import java.util.List;

public class Phones {
	private List<String> phoneNumbers;

	public Phones(List<String> phoneNumbers) {
		super();
		this.phoneNumbers = phoneNumbers;
	}

	public Phones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Phones [phoneNumbers=" + phoneNumbers + "]";
	}
	
}
