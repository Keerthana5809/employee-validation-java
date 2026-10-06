package com.wipro.empvalidation.util;

/**
 * Utility class containing standard regular expression patterns for validation.
 */
public class RegexPatterns {

    /**
     * Standard Email Regex Pattern
     */
    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    /**
     * 10-digit Indian Mobile Number Regex Pattern (Starts with 6-9)
     */
    public static final String PHONE_REGEX = "^[6-9]\\d{9}$";

    /**
     * PAN Number Regex Pattern (5 uppercase letters, 4 digits, 1 uppercase letter)
     */
    public static final String PAN_REGEX = "^[A-Z]{5}[0-9]{4}[A-Z]$";

    /**
     * Private constructor to prevent instantiation.
     */
    private RegexPatterns() {
    }
}
