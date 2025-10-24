package com.example.connect_database_demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.connect_database_demo.DTO.request.AddUserRequest;
import com.example.connect_database_demo.DTO.request.LoginRequest;
import com.example.connect_database_demo.Models.User;
import com.example.connect_database_demo.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> GetAllUser() {
        return userRepository.findAll(); // SELECT * FROM user_table;
    }

    public User AddUser(AddUserRequest newUser) {
        // email
        // userRepository.fin
        if (userRepository.findUserByEmail(newUser.getEmail()) != null) {
            System.out.println("Email da ton tai");
            return null;
        }

        User u = new User();
        u.setEmail(newUser.getEmail());
        u.setPassword(newUser.getPassword());
        u.setFullName(newUser.getFullName());
        u.setRole("USER");

        return userRepository.save(u);
    }


    // (User request)
    public boolean Login(LoginRequest request) {
        // email, password
        User u = userRepository.findUserByEmail(request.getEmail());

        if (u == null) {
            return false;
        }
        if (u.getPassword().equals(request.getPassword())) {
            return true;
        }
        return false;
    }

    public void deleteUSer(String id) {  
        boolean exists = userRepository.existsById(id); 
        if (!exists) {
            System.out.println(" User khong ton tai voi id = " + id);
            return;
        }

        userRepository.deleteById(id);
        System.out.println("Da xoa user voi id = " + id);
    }

    public void UpdateUser(String id, User newData) {
        if (newData == null) {
            System.out.println("Update that bai");
            return;
        }

        User u_database = userRepository.findByUserId(id); // tra ve 1 User hoac null
        if (u_database == null) {
            System.out.println(" User khong ton tai voi id = " + id);
            return;
        }

        if (newData.getEmail() != null) {
            u_database.setEmail(newData.getEmail());
        }
        if (newData.getPassword() != null) {
            u_database.setPassword(newData.getPassword());
        }
        if (newData.getFullName() != null) {
            u_database.setFullName(newData.getFullName());
        }
        if (newData.getRole() != null) {
            u_database.setRole(newData.getRole());
        }

        userRepository.save(u_database);
        System.out.println("Da cap nhat user voi id = " + id);
    }
}
