package com.example.authorstudent.repository;

import com.example.authorstudent.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
}
