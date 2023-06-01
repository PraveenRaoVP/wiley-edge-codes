package com.example.SpringPractice.service;

import com.example.SpringPractice.exception.AuthorNotFoundException;
import com.example.SpringPractice.model.Author;
import com.example.SpringPractice.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepo authorRepo;
    @Override
    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public List<Author> getAuthorsList() {
        return authorRepo.findAll();
    }

    @Override
    public Author getAuthorById(Long authorId) throws AuthorNotFoundException {
        if(!authorRepo.findById(authorId).isPresent()){
            throw new AuthorNotFoundException("Author not found: " + authorId + "");
        }
        return authorRepo.findById(authorId).get();
    }
}
