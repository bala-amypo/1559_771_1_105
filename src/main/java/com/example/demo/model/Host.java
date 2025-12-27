package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "hosts")
@Data
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hostName;
    private String fullname;
    @Column(unique = true)
    private String email;
    private String department;
    private String phone;
    private LocalDateTime createdAt = LocalDateTime.now();
}