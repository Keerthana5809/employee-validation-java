package com.wipro.empvalidation.util;

/**
 * Custom Exception thrown when validation inputs are invalid (e.g., null or empty list).
 */
public class ValidationException extends Exception {

    /**
     * Parameterized constructor accepting error message.
     *
     * @param message Detailed exception message
     */
    public ValidationException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ValidationException: " + getMessage();
    }
}
