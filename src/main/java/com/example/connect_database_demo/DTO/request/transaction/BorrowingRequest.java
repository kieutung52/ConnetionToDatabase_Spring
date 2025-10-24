package com.example.connect_database_demo.DTO.request.transaction;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRequest {
    private String userId;
    private Date borrowDate;
    private List<DetailBorrowingRequest> details; 
}
