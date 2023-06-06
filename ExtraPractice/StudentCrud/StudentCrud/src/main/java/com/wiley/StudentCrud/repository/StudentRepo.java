package com.wiley.StudentCrud.repository;

import com.wiley.StudentCrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
