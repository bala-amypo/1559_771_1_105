package com.example.demo.model;

import java.time.LocalDateTime;

public class Visitor {
    private long id;
    private String fullname;
    private String email;
    private String phone;
    private String idProofNumber;
    private LocalDateTime createdAt;

    public Visitor(){}

    public Visitor(String fullname, String email, String phone, String idProofNumber, LocalDateTime createdAt) {
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.idProofNumber = idProofNumber;
        this.createdAt = createdAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdProofNumber(String idProofNumber) {
        this.idProofNumber = idProofNumber;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdProofNumber() {
        return idProofNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
}
