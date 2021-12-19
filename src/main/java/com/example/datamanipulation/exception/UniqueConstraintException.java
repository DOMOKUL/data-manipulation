package com.example.datamanipulation.exception;

public class UniqueConstraintException extends RuntimeException {
    public UniqueConstraintException(Throwable cause) {
        super(cause);
    }

    public UniqueConstraintException(String message) {
        super(message);
    }
}