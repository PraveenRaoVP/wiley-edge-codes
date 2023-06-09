package com.shivam.library.controller;

import com.shivam.library.service.ManagementService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/managements")
public class ManagementController {

    private final ManagementService managementService;

    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }

    @PostMapping("/{id}/approve-publication")
    public void approvePublication(@PathVariable("id") Long id) {
        managementService.approvePublication(id);
    }
}

