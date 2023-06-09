package com.example.authorstudent.controller;

import com.example.authorstudent.model.Author;
import com.example.authorstudent.model.Book;
import com.example.authorstudent.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/create")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    @GetMapping("/{authorId}/books")
    public List<Book> getBooksByAuthorId(@PathVariable Long authorId) {
        return authorService.getBooksByAuthorId(authorId);
    }

    @PostMapping("/{authorId}/books")
    public Book createBook(@PathVariable Long authorId, @RequestBody Book book) {
        return authorService.createBook(authorId, book);
    }

    // Other controller methods, if needed
}

