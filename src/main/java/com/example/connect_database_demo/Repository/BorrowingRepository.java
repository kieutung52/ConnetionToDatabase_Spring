package com.example.connect_database_demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.connect_database_demo.Models.Borrowings;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowings, Integer>{
}