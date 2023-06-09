package com.example.github.exception.handler;

import com.example.github.exception.NotAcceptableException;
import com.example.github.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@RestControllerAdvice
public class RestExceptionAdvicer {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorEntity handleUserNotFoundException(UserNotFoundException exception){
        return ErrorEntity.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
    }
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    ErrorEntity handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException exception){
        return ErrorEntity.builder()
                .status(HttpStatus.NOT_ACCEPTABLE)
                .message(exception.getMessage())
                .build();
    }
}
