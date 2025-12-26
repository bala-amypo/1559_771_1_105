package com.example.demo.util;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^[0-9]{7,15}$" // simple numeric phone validation
    );

    /**
     * Validate email format
     * @param email String
     * @return true if valid
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validate phone number
     * @param phone String
     * @return true if valid
     */
    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.isEmpty()) return false;
        return PHONE_PATTERN.matcher(phone).matches();
    }

    /**
     * Validate ID proof number (simple non-empty check)
     */
    public static boolean isValidIdProof(String idProof) {
        return idProof != null && !idProof.trim().isEmpty();
    }

    /**
     * Validate that appointment date is not in the past
     */
    public static boolean isValidAppointmentDate(LocalDate date) {
        if (date == null) return false;
        return !date.isBefore(LocalDate.now());
    }

    /**
     * Validate alert message is non-blank
     */
    public static boolean isValidAlertMessage(String msg) {
        return msg != null && !msg.trim().isEmpty();
    }
}
