package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.security.JwtUtil;

@Service
public class AuthServiceImpl {

    private final JwtUtil jwtUtil;

    @Autowired
    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String login(String username, String role) {
        // Example: generate token for 1 hour
        long expiration = 1000L * 60 * 60; // 1 hour
        String extra = "optional-data";

        return jwtUtil.generateToken(username, role, expiration, extra);
    }
}
