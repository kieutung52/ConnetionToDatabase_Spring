package com.example.connect_database_demo.DTO.request.transaction;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailBorrowingRequest {
    private int bookId;
    private int quantityBook;
    private Date dueDate;
}
