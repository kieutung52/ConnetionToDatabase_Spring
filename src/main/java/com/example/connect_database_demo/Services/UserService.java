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
        userRepository.existsById(id); // tra ve true hoac false
        userRepository.deleteById(id);
    }

    public void UpdateUser(String id, User newData) {
        User u_database = userRepository.findByUserId(id);// tra ve 1 User hoac null
        u_database.setEmail(newData.getEmail());
        //....
        userRepository.save(u_database);
    }
}
