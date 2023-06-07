package com.example.appointmentauthor.model;






import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "management", cascade = CascadeType.ALL)
    private Book book;

    // Other properties and methods
}

