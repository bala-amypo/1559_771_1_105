package com.example.demo.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;    // User email for login
    private String password; // Plain text password
}