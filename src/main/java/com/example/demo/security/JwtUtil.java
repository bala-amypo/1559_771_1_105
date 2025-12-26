package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private String secret = "0123456789ABCDEF0123456789ABCDEF"; // 32 chars
    private long jwtExpirationMs = 3600000; // 1 hour

    public String generateToken(String username, String role, Long userId, String email) {
        return Jwts.builder()
                .claim("role", role)
                .claim("userId", userId)
                .claim("email", email)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Jws<Claims> validateAndGetClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }
}
