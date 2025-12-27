package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_notifications")
@Data
public class AlertNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alertMessage;
    private String sentTo;
    private LocalDateTime sentAt;

    @OneToOne
    @JoinColumn(name = "visit_log_id")
    private VisitLog visitLog;

    @PrePersist
    protected void onCreate() {
        this.sentAt = LocalDateTime.now();
    }
}