package com.example.first_spring_app.service;

import com.example.first_spring_app.dto.UserDto;
import org.springframework.stereotype.Service;

//@Service
public class UserService {

    public UserDto getUserById(long id) {
        return UserDto.builder()
                .id(id)
                .username("username" + id)
                .password("password" + id)
                .build();
    }


    public UserDto getUserByName(String name) {
        return UserDto.builder()
                .id(5L)
                .username(name)
                .password("password")
                .build();
    }
}
