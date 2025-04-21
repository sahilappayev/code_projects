package com.example.first_spring_app.controller;

import com.example.first_spring_app.config.Config;
import com.example.first_spring_app.dto.UserDto;
import com.example.first_spring_app.service.UserService;
import jakarta.servlet.Servlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Scope("singleton")
@RequestMapping("/users")
public class UserController {

    // injection: field, method, constructor

    // field injection
    //    @Autowired
    private final UserService userService;

    // constructor injection
//    public UserController(UserService userService) {
////        Config config = applicationContext.getBean(Config.class);
////
////        System.out.println("Config = " + config);
////
////        this.userService = applicationContext.getBean(UserService.class);
//        this.userService = userService;
//    }

    @GetMapping
    public List<UserDto> getAllUsers(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "test");
//        cookie.setPath("/");
        response.addCookie(cookie);

        return List.of(userService.getUserById(5L),
                userService.getUserByName("test"));
    }


    @GetMapping("/by-id")
    public UserDto getUser(@RequestParam Long id, @CookieValue("myCookie") Cookie cookie) {

        System.err.println("MyCookie: " + cookie.getValue());

        return userService.getUserById(id);
    }

    @GetMapping(value = "/by-name")
    public UserDto getUserByName(@RequestParam String name) {
        return userService.getUserByName(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userDto;
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable(name = "id") Long userId,
                                              @RequestBody UserDto userDto,
                                              HttpServletRequest request,
                                              HttpServletResponse response) {

        Iterator<String> headerNames = request.getHeaderNames().asIterator();
        headerNames.forEachRemaining(name -> System.out.println(name + " : " + request.getHeader(name)));


        userDto.setId(userId);

        response.setStatus(HttpStatus.BAD_GATEWAY.value());
        return "Ugurlu Emeliyyat!";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") Long userId,
                           @RequestHeader(name = "x-user-id") String xUserId) {
        // service call
        System.out.println("Deleting xUserId " + xUserId);
    }


    // method injection
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}
