package org.mn.booking.mapper;

import org.mn.booking.dto.request.UserRequestDto;
import org.mn.booking.dto.response.UserResponseDto;
import org.mn.booking.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDto userRequestDto) {
        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        return user;
    }

    public UserResponseDto toUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setCreatedAt(user.getCreatedAt());
        userResponseDto.setUpdatedAt(user.getUpdatedAt());
        return userResponseDto;
    }


}
