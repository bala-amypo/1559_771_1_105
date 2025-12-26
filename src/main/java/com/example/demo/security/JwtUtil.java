package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // Minimum 32 characters for HS256
    private final String secret =
            "mysecretkeymysecretkeymysecretkey12345";

    private final long jwtExpirationMs = 86400000; // 1 day

    public String generateToken(String email,
                                String role,
                                Long userId) {

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + jwtExpirationMs)
                )
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims validateAndGetClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
