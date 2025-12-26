package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component  // Make Spring manage this bean
public class JwtUtil {
    private final String SECRET_KEY = "your_secret_key";

    public String generateToken(String username) {
        return "token"; // your implementation
    }

    public boolean validateToken(String token, String username) {
        return true; // your implementation
    }
}
