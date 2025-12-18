package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlertNotificationDTO {

    private Long id;
    private Long visitLogId;
    private String sentTo;
    private String alertMessage;
    private LocalDateTime sentAt;
}
