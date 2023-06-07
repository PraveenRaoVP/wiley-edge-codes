package com.example.appointmentauthor.controller;

import com.example.appointmentauthor.model.Author;

import com.example.appointmentauthor.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "author";
    }

    @GetMapping("/authors/{id}")
    public String getAuthor(@PathVariable Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "author-details";
    }

    @PostMapping("/authors")
    public String addAuthor(@ModelAttribute("author") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/{id}/edit")
    public String editAuthorForm(@PathVariable Long id, Model model) {
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "author-edit";
    }

    @PostMapping("/authors/{id}/edit")
    public String editAuthor(@PathVariable Long id, @ModelAttribute("author") Author author) {
        author.setId(id);
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/{id}/delete")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }
}

