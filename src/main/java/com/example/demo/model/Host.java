package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hosts")
@Data
public class Host {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hostName;
    @Column(unique = true)
    private String email;
    private String phone;
    private String department; [cite: 43, 44, 46, 47, 48]
}