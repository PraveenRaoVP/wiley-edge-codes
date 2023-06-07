package com.example.appointmentauthor.exception;

public class AuthorNotFoundException extends Exception{
    public AuthorNotFoundException() {
        super();
    }

    public AuthorNotFoundException(String message) {
        super(message);
    }

    public AuthorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorNotFoundException(Throwable cause) {
        super(cause);
    }

    public AuthorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}