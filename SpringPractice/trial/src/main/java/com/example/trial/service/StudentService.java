package com.example.trial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trial.models.Author;
import com.example.trial.models.Student;
import com.example.trial.repository.AuthorRepository;
import com.example.trial.repository.StudentRepository;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, AuthorRepository authorRepository) {
        this.studentRepository = studentRepository;
        this.authorRepository = authorRepository;
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public void createStudent(Student student) {
        studentRepository.save(student);
    }


    public void addAuthorToStudent(Long authorId, Long studentId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalAuthor.isPresent() && optionalStudent.isPresent()) {
            Author author = optionalAuthor.get();
            Student student = optionalStudent.get();

            student.getAuthors().add(author);
            author.getStudents().add(student);

            studentRepository.save(student);
            authorRepository.save(author);
        }
    }


    public void removeAuthorFromStudent(Long authorId, Long studentId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalAuthor.isPresent() && optionalStudent.isPresent()) {
            Author author = optionalAuthor.get();
            Student student = optionalStudent.get();

            student.getAuthors().remove(author);
            author.getStudents().remove(student);

            studentRepository.save(student);
            authorRepository.save(author);
        }
    }
}
