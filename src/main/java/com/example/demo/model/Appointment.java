package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate appointmentDate;
    private String purpose;
    private String status = "SCHEDULED"; [cite: 67, 70]

    @ManyToOne @JoinColumn(name = "visitor_id")
    private Visitor visitor;
    @ManyToOne @JoinColumn(name = "host_id")
    private Host host; [cite: 73, 74]
}