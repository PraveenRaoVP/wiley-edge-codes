package com.example.SpringPractice.controller;

import com.example.SpringPractice.model.Course;
import com.example.SpringPractice.model.Student;
import com.example.SpringPractice.repository.CourseRepo;
import com.example.SpringPractice.repository.StudentRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private CourseRepo courseRepository;

    // Endpoint to create a new student
    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student) {
        Set<Course> courses = student.getCourses();
    //    studentRepository.save(student);
        courses.forEach(course -> {
            course.getStudents().add(student);
            courseRepository.save(course);
        });
        return studentRepository.save(student);
    }

    // Endpoint to create a new course
    @PostMapping("/createCourse")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // Endpoint to associate a student with a course
    @PostMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<String> addCourseToStudent(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        student.getCourses().add(course);
        studentRepository.save(student);

        return ResponseEntity.ok("Course added to student successfully");
    }
    @GetMapping("/all/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("student/{id}")
    public Student getStudentById(@PathVariable("id") Long studId) {
        return studentRepository.findById(studId).get();
    }

    @GetMapping("student/{name}")
    public List<Student> getStudentContainsName(@PathVariable("name") String studName) {
        return studentRepository.findByNameContaining(studName);
    }

    @GetMapping(value = "/search/{price}")
    public List<Course> getCourseLessThanFee(@PathVariable("price") Double fee) {
        return courseRepository.findByFeeLessThan(fee);
    }

    // Other endpoints for getting, updating, and deleting students and courses
}
