package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody User user) {
        User saved = userService.registerUser(user);
        return new ResponseEntity<>(new ApiResponse(true, "User registered", saved), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody AuthRequest request) {

        User user = userService.findByEmail(request.getEmail());

        if (!user.getPassword().equals(request.getPassword())) {
            return new ResponseEntity<>(
                    new ApiResponse(false, "Invalid credentials", null),
                    HttpStatus.UNAUTHORIZED
            );
        }

        // No JWT — return a dummy token or null
        AuthResponse response = new AuthResponse(
                "NO_TOKEN_SECURITY_DISABLED",
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(new ApiResponse(true, "Login successful", response));
    }
}
