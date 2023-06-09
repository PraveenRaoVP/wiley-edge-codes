package com.example.appointmentauthor.controller;

import com.example.appointmentauthor.exception.BookNotFoundException;
import com.example.appointmentauthor.model.Author;
import com.example.appointmentauthor.model.Book;
import com.example.appointmentauthor.model.Management;
import com.example.appointmentauthor.repository.AuthorRepository;
import com.example.appointmentauthor.service.ManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManagementController {

    private final ManagementService managementService;

    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @GetMapping("/management")
    public String getManagement(Model model) {
        Management management = managementService.getManagement();
        model.addAttribute("management", management);
        return "management";
    }

    @GetMapping("/management/approve")
    public String approveBookForm(Model model) {
        List<Book> unapprovedBooks = managementService.getUnapprovedBooks();
        model.addAttribute("unapprovedBooks", unapprovedBooks);
        return "approve-book";
    }

    @PostMapping("/management/approve/{id}")
    public String approveBook(@PathVariable Long id) throws BookNotFoundException {
        managementService.approveBook(id);
        return "redirect:/management/approve";
    }
}
