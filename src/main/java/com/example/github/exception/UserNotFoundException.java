package com.example.github.exception;


public class UserNotFoundException extends Exception {
    public UserNotFoundException(String username) {
        super("Not found user: %s".formatted(username));
    }
}
