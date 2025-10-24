package com.example.connect_database_demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.connect_database_demo.DTO.request.CreateNewBook;
import com.example.connect_database_demo.Models.Book;
import com.example.connect_database_demo.Repository.BookRepository;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;

    public Book createNewBook (CreateNewBook request) {
        Book newBook = new Book();
        newBook.setAuthor(request.getAuthor());
        newBook.setDescription(request.getDescription());
        newBook.setTitle(request.getTitle());

        Book SavedBook = bookRepository.save(newBook);
        return SavedBook;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book updateBook (int bookId, Book newData){
        Book bookUpdate = bookRepository.findById(bookId).orElse(null);
        if(bookUpdate == null){
            return null;
        }

        bookUpdate.setAuthor(newData.getAuthor());
        bookUpdate.setTitle(newData.getTitle());
        bookUpdate.setDescription(newData.getDescription());


        return bookRepository.save(bookUpdate);
    }

    public boolean deleteBook(int bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if (!exists) {
            System.out.println("Book khong ton tai voi id = " + bookId);
            return false;
        }

        bookRepository.deleteById(bookId);
        System.out.println("Da xoa book voi id = " + bookId);
        return true;
    }

}   
