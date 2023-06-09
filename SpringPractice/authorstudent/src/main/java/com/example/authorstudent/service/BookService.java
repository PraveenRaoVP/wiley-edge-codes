package com.example.authorstudent.service;

import com.example.authorstudent.model.Author;
import com.example.authorstudent.model.Book;
import com.example.authorstudent.model.Management;
import com.example.authorstudent.repository.AuthorRepository;
import com.example.authorstudent.repository.BookRepository;
import com.example.authorstudent.repository.ManagementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ManagementRepository managementRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, ManagementRepository managementRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.managementRepository = managementRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + id));
    }

    public Book createBook(Long authorId, Book book) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with id: " + authorId));

        Management management = managementRepository.save(new Management());

        book.setAuthor(author);
        book.setManagement(management);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void approveBook(Long id) {
        Book book = getBookById(id);
        book.setPublished(true);
        bookRepository.save(book);
    }

    // Other service methods, if needed
}

