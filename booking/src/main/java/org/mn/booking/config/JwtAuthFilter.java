package org.mn.booking.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.mn.booking.dto.response.ExceptionResponse;
import org.mn.booking.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    private static final String AUTHORITY = "authority";

    private final JwtService jwtService;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader(AUTHORIZATION_HEADER);  // Bearer eydfglkndgf.sdhghf.sdghkrshkus


        if (authHeader != null && authHeader.startsWith(BEARER_PREFIX)) {

            String jwtToken = authHeader.substring(BEARER_PREFIX.length());

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (Objects.isNull(authentication)) {
                try {
                    String username = jwtService.extractUsername(jwtToken);

                    Collection<Map<String, String>> authoritiesClaim = jwtService
                            .extractClaim(jwtToken, claims -> claims.get(JwtService.AUTHORITIES, Collection.class));

                    List<SimpleGrantedAuthority> authorities = authoritiesClaim.stream()
                            .map(a -> new SimpleGrantedAuthority(a.get(AUTHORITY)))
                            .toList();

                    if (Objects.nonNull(username) && !jwtService.isTokenExpired(jwtToken)) {
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                username, null, authorities
                        );
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }

                } catch (Exception exception) {
                    logger.error(exception.getMessage());
                    errorResponse(request, response);
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);

    }

    private static void errorResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        PrintWriter writer = response.getWriter();
        ExceptionResponse errorResponse = ExceptionResponse.builder().timestamp(LocalDateTime.now())
                .status(HttpStatus.UNAUTHORIZED)
                .errors(List.of("Invalid JWT token"))
                .path(request.getServletPath())
                .build();

        System.err.println("errorResponse: " + errorResponse);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        writer.write(objectMapper.writeValueAsString(errorResponse));
        writer.flush();
        writer.close();
    }
}
