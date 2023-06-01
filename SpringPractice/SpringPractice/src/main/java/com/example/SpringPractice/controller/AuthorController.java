package com.example.SpringPractice.controller;

import com.example.SpringPractice.exception.AuthorNotFoundException;
import com.example.SpringPractice.model.Author;
import com.example.SpringPractice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @GetMapping("/author")
    public List<Author> getAllAuthors(){
        return authorService.getAuthorsList();
    }

    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }
    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable("id") Long authorId) throws AuthorNotFoundException {
        return authorService.getAuthorById(authorId);
    }
    @GetMapping("/author/name/{name}")
    public Author getAuthorByName(@PathVariable("name") String authorName) throws AuthorNotFoundException {
        return authorService.getAuthorByName(authorName);
    }
    @PutMapping("/author/{id}")
    public Author updateAuthor(@PathVariable("id") Long authorId, @RequestBody Author author) throws AuthorNotFoundException {
        return authorService.updateAuthor(authorId, author);
    }
    @DeleteMapping("/author/{id}")
    public String deleteAuthor(@PathVariable("id") Long authorId) throws AuthorNotFoundException {
        authorService.deleteAuthorById(authorId);
        return "Author "+authorId+" "+"deleted successfully";
    }
}
