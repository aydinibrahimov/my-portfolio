package com.movie.movie.exception;

import java.io.IOException;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException(String message) {
        super(message);
    }
}
