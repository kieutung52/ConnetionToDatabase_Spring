package com.example.connect_database_demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.connect_database_demo.DTO.request.transaction.BorrowingRequest;
import com.example.connect_database_demo.DTO.response.TransactionData;
import com.example.connect_database_demo.Services.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create-transaction")
    public TransactionData taoGiaoDich(@RequestBody BorrowingRequest request) {
        return transactionService.createBorrowing(request);
    }
}
