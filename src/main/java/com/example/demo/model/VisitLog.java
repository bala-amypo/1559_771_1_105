package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_logs")
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @Column(nullable = false)
    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    @NotBlank(message = "Purpose is required")
    @Column(nullable = false)
    private String purpose;

    @NotNull(message = "Access granted flag is required")
    @Column(nullable = false)
    private Boolean accessGranted;

    @Column(nullable = false)
    private Boolean alertSent = false;

    @OneToOne(mappedBy = "visitLog", cascade = CascadeType.ALL)
    private AlertNotification alertNotification;

    @PrePersist
    public void prePersist() {
        this.checkInTime = LocalDateTime.now();
        if (this.alertSent == null) this.alertSent = false;
    }

    public VisitLog() {}

    public VisitLog(Long id, Visitor visitor, Host host, String purpose, Boolean accessGranted) {
        this.id = id;
        this.visitor = visitor;
        this.host = host;
        this.purpose = purpose;
        this.accessGranted = accessGranted;
    }

    // Getters and Setters
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

    public AlertNotification getAlertNotification() { return alertNotification; }
    public void setAlertNotification(AlertNotification alertNotification) { this.alertNotification = alertNotification; }
}
