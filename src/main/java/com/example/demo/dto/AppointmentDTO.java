package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentDTO {

    private Long id;
    private Long visitorId;
    private Long hostId;
    private LocalDate appointmentDate;
    private String purpose;
    private String status;
}
