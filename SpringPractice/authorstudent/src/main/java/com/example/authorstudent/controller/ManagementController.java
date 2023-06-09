package com.example.authorstudent.controller;

import com.example.authorstudent.model.Management;
import com.example.authorstudent.service.ManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/management")
public class ManagementController {
    private final ManagementService managementService;

    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @GetMapping
    public List<Management> getAllManagement() {
        return managementService.getAllManagement();
    }

    @GetMapping("/{id}")
    public Management getManagementById(@PathVariable Long id) {
        return managementService.getManagementById(id);
    }

    @PostMapping
    public Management createManagement(@RequestBody Management management) {
        return managementService.createManagement(management);
    }

    @DeleteMapping("/{id}")
    public void deleteManagement(@PathVariable Long id) {
        managementService.deleteManagement(id);
    }

    // Other controller methods, if needed
}
