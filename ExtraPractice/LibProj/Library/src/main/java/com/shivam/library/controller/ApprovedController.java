package com.shivam.library.controller;

import com.shivam.library.model.Approved;
import com.shivam.library.model.Author;
import com.shivam.library.service.ApprovedService;
import com.shivam.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApprovedController {
    @Autowired
    private ApprovedService service;
    @GetMapping("/approved")//mapping for GET request
    public List<Approved> getAllApproved(){

        return service.getAllApproved();
    }
    //mapping for POST request


}
