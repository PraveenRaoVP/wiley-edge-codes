package engage;

import java.util.Scanner;

public class Student {
	private String name;
	private int registerNo;
	public Student(String name, int registerNo) {
		super();
		this.name = name;
		this.registerNo = registerNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRegisterNo() {
		return registerNo;
	}
	public void setRegisterNo(int registerNo) {
		this.registerNo = registerNo;
	}
	public void display(Course obj) {
		System.out.println(this.getName()+" is learning the "+obj.getName()+" course");
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String studName = sc.nextLine();
		int regNo = Integer.parseInt(sc.nextLine());
		int id = Integer.parseInt(sc.nextLine());
		String courseName = sc.nextLine();
		Student student = new Student(studName, regNo);
		Course course = new Course(id,courseName);
		student.display(course);
	}
}

class Course{
	private int id;
	private String name;
	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
