package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_notifications")
@Data
public class AlertNotification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alertMessage;
    private String sentTo;
    private LocalDateTime sentAt; [cite: 102, 103, 104]

    @OneToOne @JoinColumn(name = "visit_log_id")
    private VisitLog visitLog; [cite: 101]

    @PrePersist
    protected void onCreate() { sentAt = LocalDateTime.now(); } [cite: 107]
}