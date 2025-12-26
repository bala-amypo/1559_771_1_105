package com.example.demo.security;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
// Use the correct JwtUtil path:
import com.example.demo.security.JwtUtil;

@Component
public class JwtAuthenticationFilter {

    private final JwtUtil jwtUtil;

    @Autowired
    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // filter logic here
}
