package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository alertNotificationRepository;
    private final VisitLogRepository visitLogRepository;

    @Autowired
    public AlertNotificationServiceImpl(AlertNotificationRepository alertNotificationRepository,
                                        VisitLogRepository visitLogRepository) {
        this.alertNotificationRepository = alertNotificationRepository;
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return alertNotificationRepository.findAll();
    }

    @Override
    public Optional<AlertNotification> getAlertById(Long id) {
        return alertNotificationRepository.findById(id);
    }

    @Override
    public AlertNotification saveAlert(AlertNotification alert) {
        return alertNotificationRepository.save(alert);
    }

    @Override
    public void deleteAlert(Long id) {
        alertNotificationRepository.deleteById(id);
    }

    @Override
    public void sendAlert(String message) {
        // Example implementation
        System.out.println("Sending alert: " + message);
    }
}
