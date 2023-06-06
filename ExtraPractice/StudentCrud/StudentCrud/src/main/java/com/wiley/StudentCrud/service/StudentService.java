package com.wiley.StudentCrud.service;

import com.wiley.StudentCrud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wiley.StudentCrud.repository.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }


}
