package com.example.demo.service;

import com.example.demo.model.AlertNotification;

import java.util.Optional;

public interface AlertNotificationService {
    void sendAlert(String message);
    Optional<AlertNotification> getAlert(Long id);
}
