package com.shivam.library.service;

import com.shivam.library.exception.ResourceNotFoundException;
import com.shivam.library.model.Approved;
import com.shivam.library.model.Book;
import com.shivam.library.repository.ApprovedRepository;
import com.shivam.library.repository.BookRepository;
import com.shivam.library.repository.ManagementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class BookService implements BookServiceImpl
{
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    ApprovedService aser;
    @Transactional
    @Override
    public void createBook(Book book) throws PlagiarismFound {

        bookRepo.save(book);
        Approved a=new Approved();
        if(book.getPlagPer()<10)
        {
            a.setBookId(book.getBookId());
            a.setBookName(book.getBookName());
            a.setAuthorId(book.getAuthorId());
            aser.addApproval(a);
        }
        else
        {
           throw new PlagiarismFound("Book not approved , plagiarism is found to be more than 10%");
        }

    }

    @Override
    public Book saveBook(Book book) {
        return null;
    }

    @Override
    public List<Book> getBooksList() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return null;
    }



}
