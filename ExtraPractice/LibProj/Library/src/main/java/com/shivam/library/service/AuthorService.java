package com.shivam.library.service;

import com.shivam.library.exception.ResourceNotFoundException;
import com.shivam.library.model.Author;
import com.shivam.library.model.Book;
import com.shivam.library.model.Student;
import com.shivam.library.repository.AuthorRepository;
import com.shivam.library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorService implements AuthorServiceImpl {
    @Autowired
    private AuthorRepository depRepo;
    private StudentRepository studentRepo;
    @Override
    public Author createAuthor(Author book) {
        return depRepo.save(book);
    }

    @Override
    public Author saveAuthor(Author book) {
        return null;
    }

    @Override
    public List<Author> getAuthorsList() {
        return  depRepo.findAll();
    }

    @Override
    public Author getAuthorById(Long bookId) {
        return depRepo.findById(bookId).get();
    }

    public void addAuthorToStudent(Long authorId, Long studentId) {
        Optional<Author> optionalAuthor = depRepo.findById(authorId);
        Optional<Student> optionalStudent = studentRepo.findById(studentId);

        if (optionalAuthor.isPresent() && optionalStudent.isPresent()) {
            Author author = optionalAuthor.get();
            Student student = optionalStudent.get();

            student.getAuthors().add(author);
            author.getStudents().add(student);

            studentRepo.save(student);
            depRepo.save(author);
        }
    }


    public void removeAuthorFromStudent(Long authorId, Long studentId) {
        Optional<Author> optionalAuthor = depRepo.findById(authorId);
        Optional<Student> optionalStudent = studentRepo.findById(studentId);

        if (optionalAuthor.isPresent() && optionalStudent.isPresent()) {
            Author author = optionalAuthor.get();
            Student student = optionalStudent.get();

            student.getAuthors().remove(author);
            author.getStudents().remove(student);

            studentRepo.save(student);
            depRepo.save(author);
        }
    }



}
