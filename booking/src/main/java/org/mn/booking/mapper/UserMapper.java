package org.mn.booking.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.mn.booking.dto.request.UserRequestDto;
import org.mn.booking.dto.response.UserResponseDto;
import org.mn.booking.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDto userRequestDto) {
        User user = new User();
        return toEntity(user, userRequestDto);
    }

    public User toEntity(User user, UserRequestDto userRequestDto) {
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
        userResponseDto.setCreatedAt(LocalDateTime.ofInstant(user.getCreatedAt().toInstant(), ZoneId.systemDefault()));
        userResponseDto.setUpdatedAt(LocalDateTime.ofInstant(user.getUpdatedAt().toInstant(), ZoneId.systemDefault()));
        return userResponseDto;
    }


}
