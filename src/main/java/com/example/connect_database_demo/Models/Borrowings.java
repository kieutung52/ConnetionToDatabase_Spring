package com.example.connect_database_demo.Models;

import java.util.Date;

import com.example.connect_database_demo.DTO.enum_data.BorrowingStatus;

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
@Table(name = "borrowing_table")
public class Borrowings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id")
    private int borrowingId;

    @ManyToOne
    @JoinColumn(
        name = "user_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_borrowings_user",
            foreignKeyDefinition = "FOREIGN KEY (user_id) REFERENCES user_table(user_id) ON UPDATE CASCADE ON DELETE CASCADE"
        )
    )
    private User user;


    @Column(name = "borrow_date", nullable = false)
    private Date borrowDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BorrowingStatus status = BorrowingStatus.PENDING;

    // public void test() {
    //     status = BorrowingStatus.COMPELETED;
    //     String str = BorrowingStatus.CANCELED.name();
    // }
}
