package com.shivam.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Management {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private Book book;

    public Management(Long id, String name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }

    public Management() {

    }

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    public void approvePublication() {
        // Approve the publication of the book
    }
}
