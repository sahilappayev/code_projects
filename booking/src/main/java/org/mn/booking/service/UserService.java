package org.mn.booking.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mn.booking.dto.request.UserRequestDto;
import org.mn.booking.dto.response.OrderResponseDto;
import org.mn.booking.dto.response.UserResponseDto;
import org.mn.booking.entity.User;
import org.mn.booking.error.EntityNotFoundException;
import org.mn.booking.mapper.OrderMapper;
import org.mn.booking.mapper.OrderMapperM;
import org.mn.booking.mapper.UserMapperM;
import org.mn.booking.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapperM userMapper;

    @Transactional
    public UserResponseDto create(UserRequestDto userRequestDto) {
        log.info("UserService: create user started with: {}", userRequestDto);
        User user = userMapper.toEntity(userRequestDto);

        UserResponseDto responseDto = userMapper
                .toUserResponseDto(userRepository.save(user));

        log.info("UserService: create user finished with: {}", responseDto);
        return responseDto;
    }

    public UserResponseDto findUserById(Long id) {
        log.info("UserService: find user by id: {}", id);
        User user = findById(id);
        return userMapper.toUserResponseDto(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class, id));
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAll() {
        log.info("UserService: find all users");
        List<User> users = userRepository.findAll();
        return userMapper.toUserResponseDtoList(users);
    }

    @Transactional
    public UserResponseDto update(Long id, UserRequestDto userRequestDto) {
        log.info("UserService: update user started with: {}", userRequestDto);
        User user = findById(id);
        userMapper.toEntity(user, userRequestDto);
        UserResponseDto responseDto = userMapper
                .toUserResponseDto(userRepository.save(user));

        log.info("UserService: update user finished with: {}", responseDto);
        return responseDto;
    }

    @Transactional
    public void delete(Long id) {
        log.info("UserService: delete user started with: {}", id);
//        userRepository.deleteById(id);
        User user = findById(id);
        userRepository.delete(user);
        log.info("UserService: delete user finished with: {}", id);
    }


}
