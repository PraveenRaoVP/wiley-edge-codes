package com.example.trial.service;


import com.example.trial.models.Book;
import com.example.trial.models.Management;
import com.example.trial.repository.BookRepository;
import com.example.trial.repository.ManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementService{
    private final ManagementRepository managementRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ManagementService(ManagementRepository managementRepository, BookRepository bookRepository) {
        this.managementRepository = managementRepository;
        this.bookRepository = bookRepository;
    }


    public void approveBook(Long bookId) {
        Management management = getManagementByBookId(bookId);
        if (management != null) {
            management.setApproval(true);
            managementRepository.save(management);
        }
    }


    public void rejectBook(Long bookId) {
        Management management = getManagementByBookId(bookId);
        if (management != null) {
            management.setApproval(false);
            managementRepository.save(management);
        }
    }


    public Management getManagementByBookId(Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            return book.getManagement();
        }
        return null;
    }
}
