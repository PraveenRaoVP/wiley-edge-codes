package com.shivam.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int publicationYear;
    @ManyToOne
    private Author author;

    public Book(Long id, String name, String description, int publicationYear, Author author) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public Book() {

    }

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
}
