package com.vistar.exception;

/**
 * Exception raising when data are incorrect.
 */
public class ValidationException extends RuntimeException {
    public ValidationException(final String message) {
        super(message);
    }
}
