package com.inspire.auth.exception;

public class InvalidJwtAuthenticationException extends Exception {
    public InvalidJwtAuthenticationException() {
    }

    public InvalidJwtAuthenticationException(String message) {
        super(message);
    }
}
