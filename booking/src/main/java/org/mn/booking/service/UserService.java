package org.mn.booking.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mn.booking.dto.request.UserRequestDto;
import org.mn.booking.dto.response.UserResponseDto;
import org.mn.booking.entity.User;
import org.mn.booking.error.EntityNotFoundException;
import org.mn.booking.mapper.UserMapper;
import org.mn.booking.repository.UserRepository;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserResponseDto create(UserRequestDto userRequestDto) {
        log.info("UserService: create user started with: {}", userRequestDto);
        User user = userMapper.toEntity(userRequestDto);

        UserResponseDto responseDto = userMapper
                .toUserResponseDto(userRepository.save(user));

        log.info("UserService: create user finished with: {}", responseDto);
        return responseDto;
    }

    public UserResponseDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class, id));

        return userMapper.toUserResponseDto(user);
    }

    public List<UserResponseDto> findAll(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userMapper::toUserResponseDto)
                .collect(Collectors.toList());
    }


}
