package com.example.trial.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.trial.service.ManagementService;

@Controller
@RequestMapping("/management")
public class ManagementController {
    private final ManagementService managementService;

    @Autowired
    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @PostMapping("/approve/{bookId}")
    public String approveBook(@PathVariable("bookId") Long bookId) {
        managementService.approveBook(bookId);
        return "redirect:/books";
    }

    @PostMapping("/reject/{bookId}")
    public String rejectBook(@PathVariable("bookId") Long bookId) {
        managementService.rejectBook(bookId);
        return "redirect:/books";
    }

    @GetMapping("/{bookId}")
    public String getManagementByBookId(@PathVariable("bookId") Long bookId) {
        managementService.getManagementByBookId(bookId);
        return "redirect:/books";
    }
}
