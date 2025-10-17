package com.example.connect_database_demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.connect_database_demo.Models.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public User findUserByEmail(String email);
    public User findByUserId(String id);
}