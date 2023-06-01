package com.example.SpringPractice.repository;

import com.example.SpringPractice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.bookName = ?1")
    Book findBookByName(String bookName);
}
