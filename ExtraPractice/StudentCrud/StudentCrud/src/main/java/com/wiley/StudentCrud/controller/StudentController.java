package com.wiley.StudentCrud.controller;

import com.wiley.StudentCrud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.wiley.StudentCrud.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String viewHomePage(Model model){
        List<Student> listStudents = studentService.getAllStudents();
        model.addAttribute("listStudents", listStudents);
        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addNewStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "new";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editStudent(@PathVariable(name = "id") Long id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit";
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
