package com.example.connect_database_demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue()
    private Long id;
    private String title;
    private String author;
    private String description;
}
