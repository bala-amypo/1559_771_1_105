package com.example.demo.service;

import com.example.demo.model.AlertNotification;

import java.util.List;
import java.util.Optional;

public interface AlertNotificationService {
    List<AlertNotification> getAllAlerts();
    Optional<AlertNotification> getAlertById(Long id);
    AlertNotification saveAlert(AlertNotification alert);
    void deleteAlert(Long id);
    void sendAlert(String message); // required method
}
