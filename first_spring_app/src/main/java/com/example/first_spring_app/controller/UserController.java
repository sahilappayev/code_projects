package com.example.first_spring_app.controller;

import com.example.first_spring_app.dto.UserDto;
import com.example.first_spring_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public UserDto getUser(@RequestParam Long id) {
        return userService.getUserById(id);
    }

}
