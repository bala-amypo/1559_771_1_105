package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.*;

public class JwtUtil {

    private String secret;
    private long jwtExpirationMs;

    public String generateToken(String username, String role,
                                Long userId, String email) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("userId", userId);
        claims.put("email", email);

        return Jwts.builder()
            .setClaims(claims)
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS256, secret.getBytes())
            .compact();
    }

    public Jws<Claims> validateAndGetClaims(String token) {
        return Jwts.parser()
            .setSigningKey(secret.getBytes())
            .parseClaimsJws(token);
    }
}
