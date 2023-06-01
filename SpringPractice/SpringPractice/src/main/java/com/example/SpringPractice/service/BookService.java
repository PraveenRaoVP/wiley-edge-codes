package com.example.SpringPractice.service;

import com.example.SpringPractice.exception.BookNotFoundException;
import com.example.SpringPractice.model.Book;

import java.util.List;

public interface BookService {
    public Book createBook(Book book);
    public List<Book> getBooksList();
    public Book getBookById(Long bookId) throws BookNotFoundException;
    public Book getBookByName(String bookName) throws BookNotFoundException;

}
