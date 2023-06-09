package com.shivam.library.controller;

import com.shivam.library.model.Author;
import com.shivam.library.model.Book;
import com.shivam.library.model.Management;
import com.shivam.library.service.ManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managements")
public class ManagementController {

    private final ManagementService managementService;

    @GetMapping
    public List<Management> getAllManagers() {
        return managementService.getAllManagers();
    }

    @PostMapping
    public void addBook(@RequestBody Management book) {
        managementService.addManager(book);
    }
    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

   /* @PostMapping("/{id}/approve-publication")
    public void approvePublication(@PathVariable("id") Long id) {
        managementService.approvePublication(id);
    }*/
}

