package com.example.SpringPractice.service;

import com.example.SpringPractice.exception.BookNotFoundException;
import com.example.SpringPractice.model.Book;
import com.example.SpringPractice.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepo bookRepo;
    @Override
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getBooksList() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(Long bookId) throws BookNotFoundException {
        if(!bookRepo.findById(bookId).isPresent()){
            throw new BookNotFoundException("Book not found"+bookId+"");
        }
        return bookRepo.findById(bookId).get();
    }
    @Override
    public Book getBookByName(String bookName) throws BookNotFoundException {
        if(bookRepo.findBookByName(bookName)==null){
            throw new BookNotFoundException("Book not found"+bookName+"");
        }
        return bookRepo.findBookByName(bookName);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepo.deleteById(bookId);
    }

    @Override
    public Book updateBook(Long bookId, Book book) throws BookNotFoundException {
        Book b = bookRepo.findById(bookId).get();

        if(!"".equalsIgnoreCase(b.getBookName())){
            b.setBookName(book.getBookName());
        }
        if(b.getAuthorId()!=null){
            b.setAuthorId(book.getAuthorId());
        }
        return bookRepo.save(b);
    }
}
