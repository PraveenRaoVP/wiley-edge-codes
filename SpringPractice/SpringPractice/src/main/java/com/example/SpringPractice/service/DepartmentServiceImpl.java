package com.example.SpringPractice.service;

import com.example.SpringPractice.exception.DepartmentNotFoundException;
import com.example.SpringPractice.model.Department;
import com.example.SpringPractice.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo depRepo;
    @Override
    public Department createDepartment(Department department) {
        return depRepo.save(department);
    }

    @Override
    public Department saveDepartment(Department department) {
        return null;
    }

    @Override
    public List<Department> getDepartmentsList() {
        return depRepo.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        if(!depRepo.findById(departmentId).isPresent()){
            throw new DepartmentNotFoundException("Department not found: " + departmentId + "");
        }
        return depRepo.findById(departmentId).get();
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {

    }

    @Override
    public Department updateDepartment(Department departmentId, Department department) {
        return null;
    }
}
