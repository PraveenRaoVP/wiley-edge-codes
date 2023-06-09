//package com.example.trial.controller;
//
//import com.example.trial.models.Author;
//import com.example.trial.models.Student;
//import com.example.trial.repository.AuthorRepository;
//import com.example.trial.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/appointments")
//public class AppointmentController {
//
//    private final StudentRepository studentRepository;
//    private final AuthorRepository authorRepository;
//
//    @Autowired
//    public AppointmentController(StudentRepository studentRepository, AuthorRepository authorRepository) {
//        this.studentRepository = studentRepository;
//        this.authorRepository = authorRepository;
//    }
//
//    @GetMapping
//    public String showAppointments(Model model) {
//        model.addAttribute("students", studentRepository.findAll());
//        model.addAttribute("authors", authorRepository.findAll());
//        return "appointments/list";
//    }
//
//    @PostMapping
//    public String makeAppointment(@RequestParam("studentId") Long studentId,
//                                  @RequestParam("authorId") Long authorId) {
//        Student student = studentRepository.findById(studentId).orElseThrow();
//        Author author = authorRepository.findById(authorId).orElseThrow();
//
//        student.getAuthors().add(author);
//        author.getStudents().add(student);
//
//        studentRepository.save(student);
//        authorRepository.save(author);
//
//        return "redirect:/appointments";
//    }
//}
