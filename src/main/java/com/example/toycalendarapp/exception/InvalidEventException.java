package com.example.toycalendarapp.exception;

public class InvalidEventException extends RuntimeException{
    public InvalidEventException(String message) {
        super(message);
    }
}
