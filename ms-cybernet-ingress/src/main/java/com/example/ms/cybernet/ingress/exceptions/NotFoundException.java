package com.example.ms.cybernet.ingress.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {
    private String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }

}
