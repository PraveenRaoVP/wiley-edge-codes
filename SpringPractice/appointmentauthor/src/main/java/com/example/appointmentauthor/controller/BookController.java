package com.example.appointmentauthor.controller;

import com.example.appointmentauthor.model.Book;
import com.example.appointmentauthor.service.BookService;
import com.example.appointmentauthor.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private final BookService bookService;
    @Autowired
    private final ManagementService managementService;

    public BookController(BookService bookService, ManagementService managementService) {
        this.bookService = bookService;
        this.managementService = managementService;
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book-details";
    }

    @PostMapping("/books")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/edit")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book-edit";
    }

    @PostMapping("/books/{id}/edit")
    public String editBook(@PathVariable Long id, @ModelAttribute("book") Book book) {
        book.setId(id);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @PostMapping("/approveBook/{id}")
    public String approveBook(@PathVariable Long id) {
        managementService.approveBook(id);
        return "redirect:/books";
    }
}
