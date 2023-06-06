package com.wiley.CrudOperationManyToManyMapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wiley.CrudOperationManyToManyMapping.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	List<Student> findByNameContaining(String name);
}
