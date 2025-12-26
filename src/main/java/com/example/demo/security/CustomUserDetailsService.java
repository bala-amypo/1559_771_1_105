package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Demo in-memory user (replace with DB later)
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = new User();
        user.setUsername(username);
        user.setPassword("$2a$10$7Qz...dummy"); // bcrypt hash placeholder
        user.setRole("USER");

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
