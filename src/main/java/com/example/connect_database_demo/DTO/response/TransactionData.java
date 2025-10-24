package com.example.connect_database_demo.DTO.response;

import java.util.List;

import com.example.connect_database_demo.Models.BorrowingDetails;
import com.example.connect_database_demo.Models.Borrowings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionData {
    private Borrowings borrowings;
    private List<BorrowingDetails> borrowingDetails;
}
