package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void sendAlert(String message) {
        AlertNotification alert = new AlertNotification();
        alert.setMessage(message);
        alertNotificationRepository.save(alert);
    }

    @Override
    public Optional<AlertNotification> getAlert(Long id) {
        return alertNotificationRepository.findById(id);
    }
}
