package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.util.Date;

public class JwtUtil {
    private String secret; [cite: 362]
    private Long jwtExpirationMs; [cite: 363]

    public String generateToken(String username, String role, Long userId, String email) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("userId", userId)
                .claim("email", email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact(); [cite: 365, 369, 370, 371]
    }

    public Jws<Claims> validateAndGetClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token); [cite: 366]
    }
}