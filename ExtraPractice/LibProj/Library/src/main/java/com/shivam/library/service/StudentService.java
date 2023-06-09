package com.shivam.library.service;

import com.shivam.library.exception.ResourceNotFoundException;
import com.shivam.library.model.Author;
import com.shivam.library.model.Student;
import com.shivam.library.repository.AuthorRepository;
import com.shivam.library.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public void updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);

        student.setName(studentDetails.getName());
        student.setAuthor(studentDetails.getAuthor());
        student.setAppointmentDate(studentDetails.getAppointmentDate());

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
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
