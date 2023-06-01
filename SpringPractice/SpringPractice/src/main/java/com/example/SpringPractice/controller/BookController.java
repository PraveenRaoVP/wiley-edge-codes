package com.example.SpringPractice.controller;

import com.example.SpringPractice.exception.BookNotFoundException;
import com.example.SpringPractice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.SpringPractice.model.Book;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getBooksList();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long bookId) throws BookNotFoundException {
        return bookService.getBookById(bookId);
    }
    @GetMapping("/books/name/{name}")
    public Book getBookByName(@PathVariable("name") String bookName) throws BookNotFoundException {
        return bookService.getBookByName(bookName);
    }
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable("id") Long bookId, @RequestBody Book book) throws BookNotFoundException {
        return bookService.updateBook(bookId, book);
    }
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) throws BookNotFoundException {
        bookService.deleteBookById(bookId);
        return "Book " + bookId + " " + "deleted successfully";
    }
}
