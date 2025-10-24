package com.example.connect_database_demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.connect_database_demo.Models.BorrowingDetails;

@Repository
public interface BorrowingDetailRepository extends JpaRepository<BorrowingDetails, Integer>{
    
}
