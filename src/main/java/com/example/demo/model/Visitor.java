package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitors")
@Data
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName; // [cite: 26]
    private String email;    // [cite: 27]
    private String phone;    // [cite: 28]
    private String idProofNumber; // [cite: 29]
    private LocalDateTime createdAt; // [cite: 30]

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}