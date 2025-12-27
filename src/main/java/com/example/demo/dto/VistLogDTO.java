package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VisitLogDTO {
    private Long id;
    private Long visitorId;
    private Long hostId;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String purpose;
    private Boolean accessGranted;
}