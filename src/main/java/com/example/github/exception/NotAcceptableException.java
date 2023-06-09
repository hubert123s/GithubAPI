package com.example.github.exception;

public class NotAcceptableException extends Exception {
    public NotAcceptableException(String acceptHeader) {
        super("%s is not acceptable".formatted(acceptHeader));
    }
}
