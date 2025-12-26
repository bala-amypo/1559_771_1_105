package com.example.demo.util;

public class ValidationUtil {

    public static boolean isNullOrEmpty(String val) {
        return val == null || val.trim().isEmpty();
    }
}
