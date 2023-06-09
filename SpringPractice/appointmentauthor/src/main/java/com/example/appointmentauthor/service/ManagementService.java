package com.example.appointmentauthor.service;

import com.example.appointmentauthor.exception.BookNotFoundException;
import com.example.appointmentauthor.model.Book;
import com.example.appointmentauthor.model.Management;
import com.example.appointmentauthor.repository.BookRepository;
import com.example.appointmentauthor.repository.ManagementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class ManagementService {

    private final BookRepository bookRepository;
    private final ManagementRepository managementRepository;

    public ManagementService(BookRepository bookRepository, ManagementRepository managementRepository) {
        this.bookRepository = bookRepository;
        this.managementRepository = managementRepository;
    }

    public Management getManagement() {
        return managementRepository.getManagement();
    }

    public List<Book> getUnapprovedBooks() {
        return bookRepository.findByIsApprovedFalse();
    }

    public void approveBook(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        book.setApproved(true);
        bookRepository.save(book);
    }
}
