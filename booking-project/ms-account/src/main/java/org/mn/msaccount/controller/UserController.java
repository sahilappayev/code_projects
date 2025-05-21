package org.mn.msaccount.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.mn.msaccount.dto.request.UserRequestDto;
import org.mn.msaccount.dto.response.UserResponseDto;
import org.mn.msaccount.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Operation(method = "get", description = "Userlerin hamisini qaytarir")
    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.findAll();
    }


    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/by-username/{username}")
    public UserResponseDto getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody @Valid UserRequestDto userRequestDto, HttpServletRequest request) {
        return userService.create(userRequestDto);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id,
                                      @RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.update(id, userRequestDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping("/image")
    public UserResponseDto uploadImage(@RequestParam Long userId,
                                       @RequestParam MultipartFile file) {
        return userService.uploadImage(userId, file);
    }

    @PutMapping("/image")
    public UserResponseDto updateImage(@RequestParam Long userId,
                                       @RequestParam MultipartFile file) {
        return userService.updateImage(userId, file);
    }

}
