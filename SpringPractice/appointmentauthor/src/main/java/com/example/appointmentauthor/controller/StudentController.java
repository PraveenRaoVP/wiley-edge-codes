package com.example.appointmentauthor.controller;

import com.example.appointmentauthor.model.Author;
import com.example.appointmentauthor.model.Management;
import com.example.appointmentauthor.model.Student;
import com.example.appointmentauthor.repository.AuthorRepository;
import com.example.appointmentauthor.repository.StudentRepository;
import com.example.appointmentauthor.service.AuthorService;
import com.example.appointmentauthor.service.ManagementService;
import com.example.appointmentauthor.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    private final AuthorService authorService;

    public StudentController(StudentService studentService, AuthorService authorService) {
        this.studentService = studentService;
        this.authorService = authorService;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student";
    }

    @GetMapping("/students/{id}")
    public String getStudent(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-details";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}/edit")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-edit";
    }

    @PostMapping("/students/{id}/edit")
    public String editStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        student.setId(id);
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}/appointments")
    public String getStudentAppointments(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("student", student);
        model.addAttribute("authors", authors);
        return "student-appointments";
    }

    @PostMapping("/students/{studentId}/appointments/{authorId}")
    public String addStudentAppointment(@PathVariable Long studentId, @PathVariable Long authorId) {
        studentService.addAppointment(studentId, authorId);
        return "redirect:/students/" + studentId + "/appointments";
    }

    @GetMapping("/students/{studentId}/appointments/{authorId}/cancel")
    public String cancelStudentAppointment(@PathVariable Long studentId, @PathVariable Long authorId) {
        studentService.cancelAppointment(studentId, authorId);
        return "redirect:/students/" + studentId + "/appointments";
    }
}
