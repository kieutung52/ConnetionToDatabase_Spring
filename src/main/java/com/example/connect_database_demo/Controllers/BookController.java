package com.example.connect_database_demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.connect_database_demo.DTO.request.CreateNewBook;
import com.example.connect_database_demo.Models.Book;
import com.example.connect_database_demo.Services.BookServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController

public class BookController {
    @Autowired
    private BookServices bookServices;
    
    @PostMapping("/create-book")
    public Book postMethodName(@RequestBody CreateNewBook request) {   
        return bookServices.createNewBook(request);
    }

    @GetMapping("/all-book")
    public List<Book> getAllBooks () {
        return bookServices.getAllBooks();
    }

    @PutMapping("/update-book/{id}")  
    public Book updateBook (@PathVariable int id, @RequestBody Book newData){
        return bookServices.updateBook(id, newData);
    }
    
    @DeleteMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable int id) {
        boolean ok = bookServices.deleteBook(id);
        if (ok) {
            return "Xoa thanh cong id = " + id;
        }
        return "Xoa that bai: khong tim thay id = " + id;
    }
    
}
