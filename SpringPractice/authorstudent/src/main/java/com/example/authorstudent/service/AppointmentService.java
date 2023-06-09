package com.example.authorstudent.service;

import com.example.authorstudent.model.Appointment;
import com.example.authorstudent.model.Author;
import com.example.authorstudent.model.Student;
import com.example.authorstudent.repository.AppointmentRepository;
import com.example.authorstudent.repository.AuthorRepository;
import com.example.authorstudent.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final StudentRepository studentRepository;
    private final AuthorRepository authorRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, StudentRepository studentRepository, AuthorRepository authorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.studentRepository = studentRepository;
        this.authorRepository = authorRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found with id: " + id));
    }

    public Appointment createAppointment(Long studentId, Long authorId, Appointment appointment) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + studentId));

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with id: " + authorId));

        appointment.setStudent(student);
        appointment.setAuthor(author);
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    // Other service methods, if needed
}
