package com.example.connect_database_demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.connect_database_demo.DTO.request.AddUserRequest;
import com.example.connect_database_demo.DTO.request.LoginRequest;
import com.example.connect_database_demo.Models.User;
import com.example.connect_database_demo.Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-user")
    public List<User> LayToanBoUser() {
        return userService.GetAllUser();
    }

    @PostMapping("/add-user")
    public User ThemUser(@RequestBody AddUserRequest request) {
        return userService.AddUser(request);
    }

    @PostMapping("/login/{id}")
    // /login?email=kieutung@example.com&password=123456
    public String Login(@RequestBody LoginRequest request) {
        if (userService.Login(request)) {
            return "Dang nhap thanh cong";
        }
        
        return "Dang nhap that bai";
    }
    // RequestBody, RequestParam, PathVariable.
}
