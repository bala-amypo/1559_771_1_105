package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "User registration and login") // [cite: 434]
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register") // [cite: 257]
    public ResponseEntity<ApiResponse> register(@RequestBody User user) {
        User registered = userService.registerUser(user);
        return new ResponseEntity<>(new ApiResponse(true, "User registered", registered), HttpStatus.CREATED);
    }

    @PostMapping("/login") // [cite: 262]
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // Logic to authenticate and generate AuthResponse via UserService/JwtUtil
        return ResponseEntity.ok(new AuthResponse()); 
    }
}