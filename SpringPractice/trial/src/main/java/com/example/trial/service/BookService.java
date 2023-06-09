package com.example.trial.service;



import com.example.trial.models.Author;
import com.example.trial.models.Book;
import com.example.trial.models.Management;
import com.example.trial.repository.AuthorRepository;
import com.example.trial.repository.BookRepository;
import com.example.trial.repository.ManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final ManagementRepository managementRepository;

    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, ManagementRepository managementRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.managementRepository = managementRepository;
        this.authorRepository = authorRepository;
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Book createBook(Book book) {

        return bookRepository.save(book);
    }

    public void addBookToAuthor(Long bookId, Long authorId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if (optionalBook.isPresent() && optionalAuthor.isPresent()) {
            Book book = optionalBook.get();
            Author author = optionalAuthor.get();

            book.setAuthor(author);
            author.getBooks().add(book);

            bookRepository.save(book);
            authorRepository.save(author);
        }
    }
    public List<Book> getBooksByAuthorId(Long authorId) {
        return (List<Book>) bookRepository.findByAuthorId(authorId);
    }


    public void publishBook(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            Management management = new Management();
            management.setApproval(true);
            book.setManagement(management);

            bookRepository.save(book);
        }
    }
}
