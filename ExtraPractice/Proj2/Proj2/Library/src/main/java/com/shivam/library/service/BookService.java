package com.shivam.library.service;

import com.shivam.library.exception.ResourceNotFoundException;
import com.shivam.library.model.Author;
import com.shivam.library.model.Book;
import com.shivam.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
    }

    public List<Book> getBooksByName(String name) {
        return bookRepository.findByNameContainingIgnoreCase(name);
    }
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
