package org.mn.msaccount.service;

import java.util.Collections;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mn.msaccount.dto.request.AuthRequestDto;
import org.mn.msaccount.dto.response.AuthResponseDto;
import org.mn.msaccount.error.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthService {

    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponseDto login(AuthRequestDto requestDto) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(requestDto.username());

        boolean isPassMatched = passwordEncoder.matches(requestDto.password(), userDetails.getPassword());

        if (!isPassMatched) {
            throw new AuthenticationException();
        }


        Authentication authentication = new
                UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                requestDto.password(),
                userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtService.buildAccessToken(userDetails, Map.of("issued_by", "Sahil"));
        String refreshToken = jwtService.buildRefreshToken(userDetails, Collections.emptyMap());

        return new AuthResponseDto(accessToken, refreshToken);
    }

    public AuthResponseDto refresh(String token) {
        String username = jwtService.extractUsernameRefresh(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        Authentication authentication = new
                UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                null,
                userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtService.buildAccessToken(userDetails, Map.of("issued_by", "Sahil"));
        String refreshToken = jwtService.buildRefreshToken(userDetails, Collections.emptyMap());

        return new AuthResponseDto(accessToken, refreshToken);
    }


}
