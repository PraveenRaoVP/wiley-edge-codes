package com.example.authorstudent.service;

import com.example.authorstudent.model.Author;
import com.example.authorstudent.model.Student;
import com.example.authorstudent.repository.AuthorRepository;
import com.example.authorstudent.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final AuthorRepository authorRepository;

    public StudentService(StudentRepository studentRepository, AuthorRepository authorRepository) {
        this.studentRepository = studentRepository;
        this.authorRepository = authorRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Author> getAuthorsByStudentId(Long studentId) {
        Student student = getStudentById(studentId);
        return student.getAuthors();
    }

    public void bookAppointment(Long studentId, Long authorId) {
        Student student = getStudentById(studentId);
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with id: " + authorId));

        student.getAuthors().add(author);
        studentRepository.save(student);
    }

    // Other service methods, if needed
}
