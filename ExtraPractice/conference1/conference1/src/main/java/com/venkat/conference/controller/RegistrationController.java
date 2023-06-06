package com.venkat.conference.controller;

import com.venkat.conference.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationModel", new Registration());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute("registrationModel") Registration registrationModel) {
        // Perform registration logic here
        return "redirect:/greeting";
    }
}
