package org.mn.booking.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mn.booking.dto.request.AuthRequestDto;
import org.mn.booking.dto.response.AuthResponseDto;
import org.mn.booking.error.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthService {

    private final UserDetailsService userDetailsService;


    public AuthResponseDto login(AuthRequestDto requestDto) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(requestDto.username());

        boolean isPassMatched = userDetails.getPassword().equals(requestDto.password());

        if (!isPassMatched) throw new AuthenticationException();

        Authentication authentication = new
                UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                requestDto.password(),
                userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new AuthResponseDto(null, null);
    }


}
