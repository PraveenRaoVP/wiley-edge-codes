package com.example.trial.controller;

import com.example.trial.models.Author;
import com.example.trial.models.Student;
import com.example.trial.service.StudentService;
import com.example.trial.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final AuthorService authorService;

    @Autowired
    public StudentController(StudentService studentService, AuthorService authorService) {
        this.studentService = studentService;
        this.authorService = authorService;
    }

    @GetMapping("")
    public List<Student> getAllStudents(Model model) {
        return studentService.getAllStudents();
    }

    @PostMapping("")
    public String createStudent(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/{studentId}/authors/{authorId}/add")
    public String addAuthorToStudent(
            @PathVariable("authorId") Long authorId,
            @PathVariable("studentId") Long studentId
    ) {
        studentService.addAuthorToStudent(authorId, studentId);
        return "redirect:/students";
    }

    @PostMapping("/{studentId}/authors/{authorId}/remove")
    public String removeAuthorFromStudent(
            @PathVariable("authorId") Long authorId,
            @PathVariable("studentId") Long studentId
    ) {
        studentService.removeAuthorFromStudent(authorId, studentId);
        return "redirect:/students";
    }
}
