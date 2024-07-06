package com.example.ms.cybernet.ingress.exception;

public class NotFoundException extends RuntimeException {
    String message;
    String code;

    public NotFoundException(String message) {
        super(message);

    }
}
