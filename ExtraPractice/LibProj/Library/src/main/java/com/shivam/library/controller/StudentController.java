package com.shivam.library.controller;

import com.shivam.library.model.Student;
import com.shivam.library.service.StudentService;
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
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
         return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable("id") Long id, @RequestBody Student studentDetails) {
        studentService.updateStudent(id, studentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/{studentId}/authors/{authorId}/add")
    public String addAuthorToStudent(
            @PathVariable("authorId") Long authorId,
            @PathVariable("studentId") Long studentId
    ) {
        studentService.addAuthorToStudent(authorId, studentId);
        return "Student added to author successfully";
    }

    @PostMapping("/{studentId}/authors/{authorId}/remove")
    public String removeAuthorFromStudent(
            @PathVariable("authorId") Long authorId,
            @PathVariable("studentId") Long studentId
    ) {
        studentService.removeAuthorFromStudent(authorId, studentId);
        return "Student removed from author successfully";
    }
}
