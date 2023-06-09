package com.shivam.library.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Book {
    @Id
    private long bookId;
    private String bookName;
    private double plagPer;
    private long authorId;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name= "authorId", insertable = false, updatable = false, referencedColumnName = "authorId")
    @JsonBackReference(value="book_ref")
    private Author author;
    private long managerId;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name= "managerId", insertable = false, updatable = false, referencedColumnName = "managerId")
    @JsonBackReference(value="man_ref")
    private Management management;
}