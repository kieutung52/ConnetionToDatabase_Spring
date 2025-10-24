package com.example.connect_database_demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book_table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_title" ,nullable = false, length = 100)    
    private String title;

    @Column(name = "book_author" , nullable = false, length = 100   )
    private String author;

    @Column(name = "book_description", nullable = false, length = 100)
    private String description;

    @Column (name = "book_available", nullable = false)
    private int available = 1;
}
