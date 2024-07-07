package com.example.ms.cybernet.ingress.exception;

public class NotFoundException extends RuntimeException {
    String message;

    public NotFoundException(String message) {
        super(message);

    }
}
