package com.example.connect_database_demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.connect_database_demo.DTO.enum_data.BorrowingStatus;
import com.example.connect_database_demo.DTO.request.transaction.BorrowingRequest;
import com.example.connect_database_demo.DTO.request.transaction.DetailBorrowingRequest;
import com.example.connect_database_demo.DTO.response.TransactionData;
import com.example.connect_database_demo.Models.Book;
import com.example.connect_database_demo.Models.BorrowingDetails;
import com.example.connect_database_demo.Models.Borrowings;
import com.example.connect_database_demo.Models.User;
import com.example.connect_database_demo.Repository.BookRepository;
import com.example.connect_database_demo.Repository.BorrowingDetailRepository;
import com.example.connect_database_demo.Repository.BorrowingRepository;
import com.example.connect_database_demo.Repository.UserRepository;

@Service
public class TransactionService {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private BorrowingDetailRepository borrowingDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    // add transaction
    public TransactionData createBorrowing(BorrowingRequest request) {
        //===Tìm xem userId có tồn tại không.=============
        User u = userRepository.findById(request.getUserId()).orElseThrow();
        //=================================================
        
        //===Tạo một object của Borrowings. ==============
        Borrowings borrow = new Borrowings();
        borrow.setUser(u); // set các trường cần thiết.
        borrow.setBorrowDate(request.getBorrowDate());
        borrow.setStatus(BorrowingStatus.PENDING);
        //==================================================

        Borrowings borrowSaved = borrowingRepository.save(borrow); // lưu vào db để db generate id và các trường mặc định.

        //===Tạo biến data lưu dữ liệu trả về.===========
        TransactionData data = new TransactionData();
        data.setBorrowings(borrowSaved); // dữ liệu của borrowings
        List<BorrowingDetails> dataDetails = new ArrayList<>(); // list để lưu dữ liệu của borrowingDetails
        //===================================================

        List<DetailBorrowingRequest> allBookToBorrowing = request.getDetails(); // lấy list sách mà người dùng muốn mượn

        for (DetailBorrowingRequest detailBorrowingRequest : allBookToBorrowing) {
            //===Set các trường data cần thiết=============
            BorrowingDetails borrowingDetails = new BorrowingDetails();
            borrowingDetails.setBorrowings(borrowSaved);
            borrowingDetails.setDueDate(detailBorrowingRequest.getDueDate());
            borrowingDetails.setQuantityBook(detailBorrowingRequest.getQuantityBook());
            Book book = bookRepository.findById(detailBorrowingRequest.getBookId()).orElse(null);
            borrowingDetails.setBook(book);
            //===============================================

            //===Lưu lại bản ghi của borrowingDetails vào database và add nó vào dataDetails===
            dataDetails.add(borrowingDetailRepository.save(borrowingDetails));
            //===================================================================================
        }
        data.setBorrowingDetails(dataDetails); // Lưu lại list của borrowingDetail và data trả về
        return data;
    }

    // view all transaction

    // view all transaction by user id
    // update
    // delete
    // accept or cancel transaction.

}
