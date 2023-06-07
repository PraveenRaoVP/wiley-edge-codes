package com.example.appointmentauthor.service;

import com.example.appointmentauthor.exception.AuthorNotFoundException;
import com.example.appointmentauthor.exception.StudentNotFoundException;
import com.example.appointmentauthor.model.Author;
import com.example.appointmentauthor.model.Student;
import com.example.appointmentauthor.repository.StudentRepository;
import com.example.appointmentauthor.repository.AuthorRepository;
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
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found with ID: " + authorId));
        return author.getStudents();
    }
    public void addAppointment(Long studentId, Long authorId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + authorId));

        student.getAppointments().add(author);
        studentRepository.save(student);
    }

    public void cancelAppointment(Long studentId, Long authorId) throws AuthorNotFoundException, StudentNotFoundException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + authorId));

        student.getAppointments().remove(author);
        studentRepository.save(student);
    }
    // Other methods
}

