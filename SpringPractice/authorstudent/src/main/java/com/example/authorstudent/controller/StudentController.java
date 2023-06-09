package com.example.authorstudent.controller;

import com.example.authorstudent.model.Author;
import com.example.authorstudent.model.Student;
import com.example.authorstudent.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{studentId}/authors")
    public List<Author> getAuthorsByStudentId(@PathVariable Long studentId) {
        return studentService.getAuthorsByStudentId(studentId);
    }

    @PostMapping("/{studentId}/authors/{authorId}/book-appointment")
    public void bookAppointment(@PathVariable Long studentId, @PathVariable Long authorId) {
        studentService.bookAppointment(studentId, authorId);
    }

    // Other controller methods, if needed
}

