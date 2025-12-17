package com.example.visitor.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


public class VisitLog {
   
    private Long id;
    private Visitor visitor;
    private Host host;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String purpose;
    private Boolean accessGranted;
    private Boolean alertSent = false;

    public VisitLog() {}

    public VisitLog(Visitor visitor, Host host, String purpose, Boolean accessGranted) {
        this.visitor = visitor;
        this.host = host;
        this.purpose = purpose;
        this.accessGranted = accessGranted;
        this.alertSent = false;
    }

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Visitor getVisitor() { 
        return visitor;
    }
    public void setVisitor(Visitor visitor) {
         this.visitor = visitor;
    }
    public Host getHost() {
         return host; 
    }
    public void setHost(Host host) { 
        this.host = host;
    }
    public LocalDateTime getCheckInTime() { 
        return checkInTime;
    }
    public LocalDateTime getCheckOutTime() {
         return checkOutTime; 
    }
    public void setCheckOutTime(LocalDateTime checkOutTime) { 
        this.checkOutTime = checkOutTime; 
    }
    public String getPurpose() { 
        return purpose;
    }
    public void setPurpose(String purpose) {
         this.purpose = purpose;
    }
    public Boolean getAccessGranted() {
         return accessGranted;
    }
    public void setAccessGranted(Boolean accessGranted) {
         this.accessGranted = accessGranted; 
    }
    public Boolean getAlertSent() { 
        return alertSent; 
    }
    public void setAlertSent(Boolean alertSent) {
         this.alertSent = alertSent;
    }
}
