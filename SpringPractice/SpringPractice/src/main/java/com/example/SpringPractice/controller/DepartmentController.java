package com.example.SpringPractice.controller;

import com.example.SpringPractice.exception.DepartmentNotFoundException;
import com.example.SpringPractice.model.Department;
import com.example.SpringPractice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService depService;
    @GetMapping("/departments") //mapping for GET request
    public List<Department> getAllDepartments(){

        return depService.getDepartmentsList();
    }
    //mapping for POST request
    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department){
        return depService.createDepartment(department);
    }
    //mapping for GET request with specific id
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return depService.getDepartmentById(departmentId);
    }
}
