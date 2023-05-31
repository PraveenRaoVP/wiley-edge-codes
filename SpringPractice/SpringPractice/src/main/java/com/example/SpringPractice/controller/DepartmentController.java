package com.example.SpringPractice.controller;

import com.example.SpringPractice.model.Department;
import com.example.SpringPractice.service.DepartmentService;
import com.example.SpringPractice.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService depService;
    @GetMapping("/departments")
    public List<Department> getAllDepartments(){

        return depService.getDepartmentsList();
    }
    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department){
        return depService.createDepartment(department);
    }
}
