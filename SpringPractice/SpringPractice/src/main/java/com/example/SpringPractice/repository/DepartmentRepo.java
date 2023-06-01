package com.example.SpringPractice.repository;

import com.example.SpringPractice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    @Query("SELECT d FROM Department d WHERE d.departmentName = ?1")
    public List<Department> getDepartmentByName(String departmentName);
}

