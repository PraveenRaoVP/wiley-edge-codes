package com.example.authorstudent.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Management {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "management", cascade = CascadeType.ALL)
    private List<Book> books;

    // Constructors, getters, and setters
}
