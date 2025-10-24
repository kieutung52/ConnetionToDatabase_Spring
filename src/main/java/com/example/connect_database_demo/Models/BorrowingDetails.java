package com.example.connect_database_demo.Models;

import java.util.Date;

import com.example.connect_database_demo.DTO.enum_data.BorrowingDetailStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borrowing_details")
public class BorrowingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_detail_id")
    private int borrowingDetailsId;

    @ManyToOne
    @JoinColumn(
        name = "borrow_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_borrowing_borrowingdetails",
            foreignKeyDefinition = "FOREIGN KEY (borrow_id) REFERENCES borrowing_table(borrowing_id) ON UPDATE CASCADE ON DELETE CASCADE"
        )
    )
    private Borrowings borrowings;

    @ManyToOne
    @JoinColumn(
        name = "book_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_borrowingdetails_book",
            foreignKeyDefinition = "FOREIGN KEY (book_id) REFERENCES book_table(book_id) ON UPDATE CASCADE ON DELETE CASCADE"
        )
    )
    private Book book;

    @Column(name = "quantity_book", nullable = false)
    private int quantityBook = 1;
    
    @Column(name = "due_date", nullable = false)
    private Date dueDate;

    @Column(name = "return_date", nullable = true)
    private Date returnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BorrowingDetailStatus status = BorrowingDetailStatus.BORROWING;
}
