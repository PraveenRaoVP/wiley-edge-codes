package com.example.SpringPractice.service;

import com.example.SpringPractice.exception.AuthorNotFoundException;
import com.example.SpringPractice.model.Author;

import java.util.List;

public interface AuthorService {
    public Author createAuthor(Author author);
    public List<Author> getAuthorsList();
    public Author getAuthorById(Long authorId) throws AuthorNotFoundException;
    public Author getAuthorByName(String authorName) throws AuthorNotFoundException;
    public void deleteAuthorById(Long authorId);
    public Author updateAuthor(Long authorId, Author author) throws AuthorNotFoundException;
}
