package com.shivam.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Author {
    @Id
    @GeneratedValue
    private long authorId;
    private String authorName;
    private String email;
    @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    @JsonManagedReference(value="book_ref")
    private List<Book> books;
    @ManyToMany(mappedBy = "authors")
    @JsonManagedReference(value="student_ref")
    private List<Student> students = new ArrayList<>();

}