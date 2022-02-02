package com.example.middlecrud.exceptions;

public class PassportNotFound extends RuntimeException{
    public PassportNotFound(String message) {
        super(message);
    }
}
