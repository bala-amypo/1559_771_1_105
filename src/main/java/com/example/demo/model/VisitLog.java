package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_logs")
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private Host host;

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;

    private String purpose;

    @NotNull
    @Column(nullable = false)
    private Boolean accessGranted;

    @Column(nullable = false)
    private Boolean alertSent = false;

    // ✅ Fixes missing method errors
    private String location;

    @Column(nullable = false)
    private boolean checkedOut;

    @PrePersist
    public void prePersist() {
        this.checkInTime = LocalDateTime.now();
        if (alertSent == null) alertSent = false;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Visitor getVisitor() { return visitor; }
    public void setVisitor(Visitor visitor) { this.visitor = visitor; }

    public Host getHost() { return host; }
    public void setHost(Host host) { this.host = host; }

    public LocalDateTime getCheckInTime() { return checkInTime; }
    public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; }

    public LocalDateTime getCheckOutTime() { return checkOutTime; }
    public void setCheckOutTime(LocalDateTime checkOutTime) { this.checkOutTime = checkOutTime; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public Boolean getAccessGranted() { return accessGranted; }
    public void setAccessGranted(Boolean accessGranted) { this.accessGranted = accessGranted; }

    public Boolean getAlertSent() { return alertSent; }
    public void setAlertSent(Boolean alertSent) { this.alertSent = alertSent; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public boolean isCheckedOut() { return checkedOut; }
    public void setCheckedOut(boolean checkedOut) { this.checkedOut = checkedOut; }
}
