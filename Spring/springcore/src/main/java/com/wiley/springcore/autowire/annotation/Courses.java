package com.wiley.springcore.autowire.annotation;

import java.util.Map;

public class Courses {
	private Map<String,String> courseDetails;

	public Courses(Map<String, String> courseDetails) {
		super();
		this.courseDetails = courseDetails;
	}

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Map<String, String> getCourseDetails() {
		return courseDetails;
	}

	public void setCourseDetails(Map<String, String> courseDetails) {
		this.courseDetails = courseDetails;
	}

	@Override
	public String toString() {
		return "Courses [courseDetails=" + courseDetails + "]";
	}
	
}
