package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;  // JWT token
    private Long userId;   // ID of authenticated user
    private String email;  // User email
    private String role;   // ADMIN or USER
}