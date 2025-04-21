package com.example.first_spring_app.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    private Long id;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String username;

    private String password;

}
