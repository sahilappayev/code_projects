package org.mn.msaccount.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.mn.msaccount.dto.request.AuthRequestDto;
import org.mn.msaccount.dto.response.AuthResponseDto;
import org.mn.msaccount.service.AuthService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody @Valid AuthRequestDto requestDto) {
        return authService.login(requestDto);
    }

    @PostMapping("/refresh")
    public AuthResponseDto login(@RequestParam @NotBlank String refreshToken) {
        return authService.refresh(refreshToken);
    }
}
