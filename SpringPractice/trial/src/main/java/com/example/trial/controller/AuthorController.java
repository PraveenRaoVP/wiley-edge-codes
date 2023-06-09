package com.example.trial.controller;

import com.example.trial.models.Author;
import com.example.trial.models.Book;
import com.example.trial.service.AuthorService;
import com.example.trial.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Author> getAllAuthors(Model model) {
        return authorService.getAllAuthors();
    }

    @PostMapping("/create")
    public String createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @GetMapping("/{id}/books")
    public List<Book> getBooksByAuthorId(@PathVariable("id") Long authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }

    @GetMapping("/{bookId}")
    public List<Author> getAuthorByBookId(@PathVariable("bookId") Long bookId) {
        return authorService.getAuthorsByBookId(bookId);

    }


    @PostMapping("/{authorId}/books/{bookId}/add")
    public String addAuthorToBook(
            @PathVariable("authorId") Long authorId,
            @PathVariable("bookId") Long bookId
    ) {
        authorService.addAuthorToBook(authorId, bookId);
        return "Author added successfully to book";
    }

    @PostMapping("/{authorId}/books/{bookId}/remove")
    public String removeAuthorFromBook(
            @PathVariable("authorId") Long authorId,
            @PathVariable("bookId") Long bookId
    ) {
        authorService.removeAuthorFromBook(authorId, bookId);
        return "Author removed successfully from book";
    }
}
