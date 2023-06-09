package com.shivam.library.service;

import com.shivam.library.model.Author;

import java.util.List;

public interface AuthorServiceImpl {
    public Author createAuthor(Author book);
    public Author saveAuthor(Author book);
    public List<Author> getAuthorsList();
    public Author getAuthorById(Long bookId);

}

