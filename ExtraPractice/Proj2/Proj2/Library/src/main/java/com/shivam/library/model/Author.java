package com.shivam.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "author")
    private List<Book> booksWritten;

    public Author(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.booksWritten = new ArrayList<>();
    }

    public Author() {

    }

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Book> getBooksWritten() { return booksWritten; }
    public void setBooksWritten(List<Book> booksWritten) { this.booksWritten = booksWritten; }

    public void addBook(Book book) { this.booksWritten.add(book); }
}

