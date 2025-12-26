package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "your_secret_key";

    public String generateToken(String username) {
        // existing simple version
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // New overloaded method matching your AuthServiceImpl call
    public String generateToken(String username, String role, Long expirationMillis, String somethingElse) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .claim("extra", somethingElse)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
