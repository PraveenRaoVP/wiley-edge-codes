package com.shivam.library.service;

import com.shivam.library.model.Book;

import java.util.List;

public interface BookServiceImpl {
    public void createBook(Book book) throws  PlagiarismFound;
    public Book saveBook(Book book);
    public List<Book> getBooksList();
    public Book getBookById(Long bookId) ;

}