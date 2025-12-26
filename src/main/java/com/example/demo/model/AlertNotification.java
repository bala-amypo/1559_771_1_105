package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_notifications")
public class AlertNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "visit_log_id", unique = true)
    private VisitLog visitLog;

    @NotBlank
    @Column(nullable = false)
    private String sentTo;

    @NotBlank
    @Column(nullable = false)
    private String alertMessage;  // ✅ replaces setMessage error

    private LocalDateTime sentAt;

    @PrePersist
    public void prePersist() {
        this.sentAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public VisitLog getVisitLog() { return visitLog; }
    public void setVisitLog(VisitLog visitLog) { this.visitLog = visitLog; }

    public String getSentTo() { return sentTo; }
    public void setSentTo(String sentTo) { this.sentTo = sentTo; }

    public String getAlertMessage() { return alertMessage; }
    public void setAlertMessage(String alertMessage) { this.alertMessage = alertMessage; }

    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
}
