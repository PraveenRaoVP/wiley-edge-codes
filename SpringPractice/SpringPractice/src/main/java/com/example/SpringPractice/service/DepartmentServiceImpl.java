package com.example.SpringPractice.service;

import com.example.SpringPractice.exception.DepartmentNotFoundException;
import com.example.SpringPractice.model.Department;
import com.example.SpringPractice.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public List<Department> getDepartmentByName(String departmentName) throws DepartmentNotFoundException {
        if(depRepo.getDepartmentByName(departmentName)==null){
            throw new DepartmentNotFoundException("Department not found: " + departmentName + "");
        }
        return depRepo.getDepartmentByName(departmentName);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        depRepo.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException {
        Department dep = depRepo.findById(departmentId).get();

        if(!"".equalsIgnoreCase(dep.getDepartmentName())){
            dep.setDepartmentName(department.getDepartmentName());
        }
        if(!"".equalsIgnoreCase(dep.getDepartmentAddress())){
            dep.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(!"".equalsIgnoreCase(dep.getDepartmentCode())) {
            dep.setDepartmentCode(department.getDepartmentCode());
        }
        return depRepo.save(dep);
    }
}
