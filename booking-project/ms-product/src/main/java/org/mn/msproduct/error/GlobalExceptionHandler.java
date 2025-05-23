package org.mn.msproduct.error;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mn.msproduct.client.msaccount.MsAccountException;
import org.mn.msproduct.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponse methodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                             HttpServletRequest request) {
        BindingResult bindingResult = exception.getBindingResult();
        List<String> errors = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            errors.add(field + ": " + message);
        }

        log.error(exception.getMessage(), exception);
        return ExceptionResponse.builder()
                .errors(errors)
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }


    @ExceptionHandler(MsAccountException.class)
    public ResponseEntity<ExceptionResponse> handleMsAccountException(MsAccountException exception,
                                                                      HttpServletRequest request) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.status(exception.getStatus())
                .body(ExceptionResponse.builder()
                        .errors(exception.getErrors())
                        .path(request.getRequestURI())
                        .timestamp(LocalDateTime.now())
                        .status(exception.getStatus())
                        .build());
    }

}
