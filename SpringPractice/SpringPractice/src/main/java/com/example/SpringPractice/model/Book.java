package com.example.SpringPractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private Long authorId;
    private String bookName;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name= "authorId", insertable = false, updatable = false, referencedColumnName = "authorId")
    private Author author;
}
