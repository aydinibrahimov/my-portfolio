package com.example.ms.cybernet.ingress.exceptions;

public class ExceptionResponse extends RuntimeException {
    private String code;
    private String message;

    public ExceptionResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
