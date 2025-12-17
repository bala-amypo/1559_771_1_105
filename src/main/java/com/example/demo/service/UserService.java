package com.example.visitor.service;

import com.example.visitor.model.request.RegisterRequest;
import com.example.visitor.model.request.AuthRequest;
import com.example.visitor.model.response.AuthResponse;

public interface UserService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(AuthRequest request);
}
