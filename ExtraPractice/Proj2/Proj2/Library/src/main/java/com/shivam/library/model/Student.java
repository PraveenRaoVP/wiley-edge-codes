package com.shivam.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private Author author;
    private Date appointmentDate;

    public Student(Long id, String name, Author author, Date appointmentDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.appointmentDate = appointmentDate;
    }

    public Student() {

    }

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public Date getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(Date appointmentDate) { this.appointmentDate = appointmentDate; }
}

