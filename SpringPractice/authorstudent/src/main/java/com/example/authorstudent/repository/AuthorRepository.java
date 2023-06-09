package com.example.authorstudent.repository;

import com.example.authorstudent.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Custom methods, if needed
}
