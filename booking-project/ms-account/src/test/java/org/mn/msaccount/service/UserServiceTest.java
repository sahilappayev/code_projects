package org.mn.msaccount.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mn.msaccount.client.msfile.MsFileClient;
import org.mn.msaccount.client.msproduct.MsProductClient;
import org.mn.msaccount.dto.request.UserRequestDto;
import org.mn.msaccount.dto.response.UserResponseDto;
import org.mn.msaccount.entity.User;
import org.mn.msaccount.mapper.UserMapper;
import org.mn.msaccount.repository.RoleRepository;
import org.mn.msaccount.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private MsFileClient msFileClient;

    @Mock
    private MsProductClient msProductClient;

    @Spy
    @InjectMocks
    private UserService userService;

    private User user;
    private UserRequestDto userRequestDto;
    private UserResponseDto userResponseDto;

    @BeforeEach
    void setUp() {
//        userService = Mockito
//                .spy(new UserService(userRepository, userMapper, passwordEncoder,
//                        roleRepository, msFileClient, msProductClient));

        userRequestDto = getUserRequestDto();
        user = getUser();
        userResponseDto = getUserResponseDto();
    }

    @Test
    void test_create_user_success() {
        when(userMapper.toEntity(userRequestDto)).thenReturn(user);
        when(passwordEncoder.encode(userRequestDto.getPassword())).thenReturn(user.getPassword());
        when(roleRepository.findByNameIn(userRequestDto.getRoles())).thenReturn(Collections.emptySet());
        when(userRepository.save(user)).thenReturn(user);

        when(userMapper.toUserResponseDto(user)).thenReturn(userResponseDto);

        UserResponseDto userResponseDto = userService.create(userRequestDto);

        Assertions.assertNotNull(userResponseDto);
        Assertions.assertEquals(userRequestDto.getUsername(), userResponseDto.getUsername());
    }

    @Test
    void test_create_user_when_username_is_null() {
        userRequestDto.setUsername(null);

        when(userMapper.toEntity(userRequestDto)).thenReturn(user);

        RuntimeException exception = Assertions
                .assertThrows(RuntimeException.class, () -> userService.create(userRequestDto));

        Assertions.assertTrue(exception.getMessage().contains("Invalid username"));
    }

    @Test
    void find_user_by_id_success() {
        Mockito.doReturn(user).when(userService).findById(1L);

        when(userMapper.toUserResponseDto(user)).thenReturn(userResponseDto);
        when(msProductClient.getOrdersByUserId(1L)).thenReturn(Collections.emptyList());

        UserResponseDto actual = userService.findUserById(1L);

//        Assertions.assertNotNull(actual);
//        Assertions.assertEquals(userResponseDto, actual);

        org.assertj.core.api.Assertions.assertThat(actual).usingRecursiveComparison().isEqualTo(userResponseDto);

    }


    public static UserRequestDto getUserRequestDto() {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUsername("username");
        userRequestDto.setPassword("password");
        return userRequestDto;
    }

    public User getUser() {
        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        user.setPassword(userRequestDto.getPassword());
        return user;
    }

    public UserResponseDto getUserResponseDto() {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUsername(userRequestDto.getUsername());
        userResponseDto.setPassword(userRequestDto.getPassword());
        return userResponseDto;
    }

}
