package org.mn.booking.error;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.mn.booking.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse internalException(Exception exception, HttpServletRequest request) {
        log.error(exception.getMessage(), exception);
        return ExceptionResponse.builder()
                .errors(List.of(exception.getMessage()))
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ExceptionResponse internalEntityNotFoundException(EntityNotFoundException exception,
                                                             HttpServletRequest request) {
        log.error(exception.getMessage(), exception);
        return ExceptionResponse.builder()
                .errors(List.of(exception.getMessage()))
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND)
                .build();
    }


}
