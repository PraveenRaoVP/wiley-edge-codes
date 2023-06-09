package com.example.authorstudent.controller;

import com.example.authorstudent.model.Appointment;
import com.example.authorstudent.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PostMapping("/{studentId}/{authorId}")
    public Appointment createAppointment(@PathVariable Long studentId, @PathVariable Long authorId, @RequestBody Appointment appointment) {
        return appointmentService.createAppointment(studentId, authorId, appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    // Other controller methods, if needed
}
