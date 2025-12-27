package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    private final UserRepository userRepository; // [cite: 248]
    private final PasswordEncoder passwordEncoder; // [cite: 248]

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        // Enforce default role if null [cite: 125, 249]
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        // Encrypt password before storage [cite: 124, 250]
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found")); // [cite: 251]
    }
}