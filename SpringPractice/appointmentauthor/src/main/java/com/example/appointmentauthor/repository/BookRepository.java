package com.example.appointmentauthor.repository;

import com.example.appointmentauthor.model.Author;
import com.example.appointmentauthor.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByIsApprovedFalse();
}
