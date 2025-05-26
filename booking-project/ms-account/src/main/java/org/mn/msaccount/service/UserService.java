package org.mn.msaccount.service;

import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mn.msaccount.client.msfile.MsFileClient;
import org.mn.msaccount.client.msproduct.MsProductClient;
import org.mn.msaccount.client.msproduct.OrderResponseDto;
import org.mn.msaccount.dto.request.UserRequestDto;
import org.mn.msaccount.dto.response.UserResponseDto;
import org.mn.msaccount.entity.Role;
import org.mn.msaccount.entity.User;
import org.mn.msaccount.error.EntityNotFoundException;
import org.mn.msaccount.mapper.UserMapper;
import org.mn.msaccount.repository.RoleRepository;
import org.mn.msaccount.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final MsFileClient msFileClient;
    private final MsProductClient msProductClient;


    @Transactional
    public UserResponseDto create(UserRequestDto userRequestDto) {
        log.info("UserService: create user started with: {}", userRequestDto);
        User user = userMapper.toEntity(userRequestDto);

        if (userRequestDto.getUsername() == null) throw new RuntimeException("Invalid username");

        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));

        Set<Role> roles = roleRepository.findByNameIn(userRequestDto.getRoles());
        user.setRoles(roles);

        UserResponseDto responseDto = userMapper
                .toUserResponseDto(userRepository.save(user));
        log.info("UserService: create user finished with: {}", responseDto);
        return responseDto;
    }

    public UserResponseDto findUserById(Long id) {
        log.info("UserService: find user by id: {}", id);
        User user = findById(id);

        UserResponseDto userResponseDto = userMapper.toUserResponseDto(user);

        List<OrderResponseDto> orders = msProductClient.getOrdersByUserId(id);
        userResponseDto.setOrders(orders);

        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setUsername(userResponseDto.getUsername());
        responseDto.setRoles(userResponseDto.getRoles());
        responseDto.setPassword(userResponseDto.getPassword());
        responseDto.setOrders(orders);

        return responseDto;
    }

    public UserResponseDto findByUsername(String username) {
        log.info("UserService: find user by username: {}", username);
        User user = userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new EntityNotFoundException(User.class, username));
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

        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));

        Set<Role> roles = roleRepository.findByNameIn(userRequestDto.getRoles());
        user.setRoles(roles);

        UserResponseDto responseDto = userMapper
                .toUserResponseDto(userRepository.save(user));

        log.info("UserService: update user finished with: {}", responseDto);
        return responseDto;
    }

    @Transactional
    public void delete(Long id) {
        log.info("UserService: delete user started with: {}", id);
        User user = findById(id);
        userRepository.delete(user);
        msFileClient.deleteImage(user.getImage());
        log.info("UserService: delete user finished with: {}", id);
    }

    @Transactional
    public UserResponseDto uploadImage(Long userId, MultipartFile file) {
        log.info("UserService: upload image started with: {}", userId);
        User user = findById(userId);

        String objectName = msFileClient.uploadImage(file, false);

        user.setImage(objectName);
        userRepository.save(user);
        return userMapper.toUserResponseDto(userRepository.save(user));
    }

    @Transactional
    public UserResponseDto updateImage(Long userId, MultipartFile file) {
        log.info("UserService: upload image started with: {}", userId);
        User user = findById(userId);

        String objectName = msFileClient.updateImage(user.getImage(), false, file);

        user.setImage(objectName);
        userRepository.save(user);
        return userMapper.toUserResponseDto(userRepository.save(user));
    }

}
