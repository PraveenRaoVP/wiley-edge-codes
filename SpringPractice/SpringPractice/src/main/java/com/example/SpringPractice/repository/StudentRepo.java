package com.example.SpringPractice.repository;

import com.example.SpringPractice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    // method for findNameContainingLike
    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1%")
    List<Student> findByNameContaining(String name);
}
