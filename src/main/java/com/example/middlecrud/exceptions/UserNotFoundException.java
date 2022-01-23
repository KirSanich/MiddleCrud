package com.example.middlecrud.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
