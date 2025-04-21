package com.example.first_spring_app.config;

import com.example.first_spring_app.service.UserService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ToString
@Getter
@Setter
public class Config {

    private final String name = "Config";


//    @Scope("prototype")
    @Bean
    public UserService userService(){
        return new UserService();
    }


}
