package com.example.authorstudent.service;

import com.example.authorstudent.model.Author;
import com.example.authorstudent.model.Book;
import com.example.authorstudent.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with id: " + id));
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Book> getBooksByAuthorId(Long authorId) {
        Author author = getAuthorById(authorId);
        return author.getBooks();
    }

    public Book createBook(Long authorId, Book book) {
        Author author = getAuthorById(authorId);
        book.setAuthor(author);
        return authorRepository.save(author).getBooks().get(author.getBooks().size() - 1);
    }

    // Other service methods, if needed
}

