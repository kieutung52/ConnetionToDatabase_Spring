package com.example.connect_database_demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "User_table") //
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "u_email", nullable = false, length = 100) // u_email VARCHAR(100) NOT NULL
    private String email;

    @Column(name = "u_password", nullable = false, length = 255)
    private String password;

    @Column(name = "u_fullname", nullable = false, length = 100)
    private String fullName;

    @Column(name = "u_role", nullable = false, length = 10)
    private String Role;
}
