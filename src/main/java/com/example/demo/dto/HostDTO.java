package com.example.demo.dto;

import lombok.Data;

@Data
public class HostDTO {
    private Long id;
    private String hostName;
    private String email;
    private String department;
    private String phone;
}