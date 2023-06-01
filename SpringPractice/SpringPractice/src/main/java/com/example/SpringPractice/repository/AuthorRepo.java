package com.example.SpringPractice.repository;

import com.example.SpringPractice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.authorName = ?1")
    Author getAuthorByName(String authorName);
}
