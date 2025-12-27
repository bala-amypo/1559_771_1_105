package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "visit_logs")
@Data
public class VisitLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String purpose;
    private Boolean accessGranted;
    private Boolean alertSent = false; [cite: 82, 83, 85, 86, 90]

    @ManyToOne @JoinColumn(name = "visitor_id")
    private Visitor visitor;
    @ManyToOne @JoinColumn(name = "host_id")
    private Host host; [cite: 93, 94]
}