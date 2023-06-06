package com.wiley.CrudOperationManyToManyMapping.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.CrudOperationManyToManyMapping.model.Course;
import com.wiley.CrudOperationManyToManyMapping.model.Student;
import com.wiley.CrudOperationManyToManyMapping.repository.CourseRepo;
import com.wiley.CrudOperationManyToManyMapping.repository.StudentRepo;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {
	
	@Autowired
	private StudentRepo studentrepo;
	
	@Autowired
	private CourseRepo courserepo;

	public StudentCourseController(StudentRepo studentrepo, CourseRepo courserepo) {
		super();
		this.studentrepo = studentrepo;
		this.courserepo = courserepo;
	}
	
	@PostMapping
	public Student saveStudentWithCourse(@RequestBody Student student) {
		return studentrepo.save(student);
	}
	
	@GetMapping
	public List<Student> findAllStudent(){
		return studentrepo.findAll();
	}
	
	
	@GetMapping("/{studentId}")
	public Student findStudent(@PathVariable Long studentId) {
		return studentrepo.findById(studentId).orElse(null);
	}
	
	@GetMapping("/find/{name}")
	public List<Student> findStudentsContainingByName(@PathVariable String name){
		return studentrepo.findByNameContaining(name);
	}
	
	@GetMapping("/search/{price}")
	public List<Course> findCourseLessThanPrice(@PathVariable double price){
		return courserepo.findByFeeLessThan(price);
	}
	
	
	
	
	
}

