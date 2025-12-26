package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // REQUIRED field names (tests use reflection)
    private final String secret =
            "mysecretkeymysecretkeymysecretkey12345";

    private final Long jwtExpirationMs = 86400000L;

    // ✅ EXACT method signature expected by tests
    public String generateToken(String username,
                                String role,
                                Long userId,
                                String email) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("userId", userId)
                .claim("email", email)
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
