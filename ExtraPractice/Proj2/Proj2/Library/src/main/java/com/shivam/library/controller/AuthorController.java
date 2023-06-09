package com.shivam.library.controller;

import com.shivam.library.model.Author;
import com.shivam.library.model.Book;
import com.shivam.library.service.AuthorService;
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
    public Author getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping(params = "name")
    public List<Author> getAuthorsByName(@RequestParam(name="name") String name) {
        return authorService.getAuthorsByName(name);
    }

    @GetMapping("/{id}/books")
    public List<Book> getBooksWrittenByAuthor(@PathVariable("id") Long id) {
        return authorService.getBooksWrittenByAuthor(id);
    }
    @PostMapping("/add")
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

}
