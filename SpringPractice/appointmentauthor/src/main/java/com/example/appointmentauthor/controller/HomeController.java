package com.example.appointmentauthor.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/management")
    public String management(Model model) {
        // Add logic to fetch and pass management data to the model
        return "management";
    }

    @GetMapping("/students")
    public String students(Model model) {
        // Add logic to fetch and pass student data to the model
        return "student";
    }
}

