package com.example.connect_database_demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.connect_database_demo.Models.Book;

@Repository

public interface BookRepository extends JpaRepository <Book, Integer> {
    public Book findByTitle(String title);
    public Book findByBookId(int id);
    
}
