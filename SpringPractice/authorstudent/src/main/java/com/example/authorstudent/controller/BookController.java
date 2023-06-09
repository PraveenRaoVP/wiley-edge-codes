package com.example.authorstudent.controller;

import com.example.authorstudent.model.Book;
import com.example.authorstudent.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/{authorId}")
    public Book createBook(@PathVariable Long authorId, @RequestBody Book book) {
        return bookService.createBook(authorId, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/{id}/approve")
    public void approveBook(@PathVariable Long id) {
        bookService.approveBook(id);
    }

    // Other controller methods, if needed
}
