package com.shivam.library.controller;

import com.shivam.library.model.Book;
import com.shivam.library.service.BookService;
import com.shivam.library.service.PlagiarismFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/books")//mapping for GET request
    public List<Book> getAllDepartments(){

        return bookService.getBooksList();
    }
    //mapping for POST request
    @PostMapping("/books")
    public void createBook(@RequestBody Book book) throws PlagiarismFound {
         bookService.createBook(book);
    }


}