package com.example.trial.service;

import com.example.trial.models.Book;
import com.example.trial.repository.BookRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.trial.models.Author;
import com.example.trial.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


    public String createAuthor(Author author) {
        authorRepository.save(author);
        return null;
    }

    public List<Author> getAuthorsByBookId(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return (List<Author>) book.getAuthor();
        }
        return null;
    }


    public void addAuthorToBook(Long authorId, Long bookId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalAuthor.isPresent() && optionalBook.isPresent()) {
            Author author = optionalAuthor.get();
            Book book = optionalBook.get();

            book.setAuthor(author);
            author.getBooks().add(book);

            bookRepository.save(book);
            authorRepository.save(author);
        }
    }


    public void removeAuthorFromBook(Long authorId, Long bookId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalAuthor.isPresent() && optionalBook.isPresent()) {
            Author author = optionalAuthor.get();
            Book book = optionalBook.get();

            //book.getAuthor().remove(author);
            author.getBooks().remove(book);

            bookRepository.save(book);
            authorRepository.save(author);
        }
    }
}
