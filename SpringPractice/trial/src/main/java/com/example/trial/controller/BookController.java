package com.example.trial.controller;

import com.example.trial.models.Book;
import com.example.trial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping("")
    public List<Book> getAllBooks(Model model) {
        return bookService.getAllBooks();
    }


    @PostMapping("/create")
    public Book createBook(@ModelAttribute Book book) {
        return bookService.createBook(book);
    }

    @PostMapping("/add/{bookId}/author/{authorId}")
    public String addBookToAuthor(
            @PathVariable("bookId") Long bookId,
            @PathVariable("authorId") Long authorId
    ) {
        bookService.addBookToAuthor(bookId, authorId);
        return "Book added to Author successfully";
    }

    @GetMapping("/books/{authorId}")
    public List<Book> getBooksByAuthorId(@PathVariable("authorId") Long authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }

    @PostMapping("/{id}/publish")
    public String publishBook(@PathVariable("id") Long bookId) {
        bookService.publishBook(bookId);
        return "Book published successfully";
    }
}
