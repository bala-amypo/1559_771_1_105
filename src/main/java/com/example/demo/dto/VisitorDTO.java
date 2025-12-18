package com.example.demo.dto;

import lombok.Data;

@Data
public class VisitorDTO {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String idProofNumber;
}
