package com.eugooti.restapi.controller;

import com.eugooti.restapi.entity.User;
import com.eugooti.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // You can add validation and error handling here if needed
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){

        String name=passwordEncoder.encode("Eugene");

        System.out.println(passwordEncoder.matches("Eugenee",name));



        return userService.getAllUsers();
    }
}
