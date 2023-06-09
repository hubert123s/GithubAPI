package com.example.github.exception.handler;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ErrorEntity {
    private HttpStatus status;
    private String message;
}
