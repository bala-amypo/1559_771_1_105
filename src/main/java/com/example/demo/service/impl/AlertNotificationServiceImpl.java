package com.example.demo.service;

import com.example.demo.model.AlertNotification;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
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
        // optionally validate visit log existence
        if (alert.getVisitLog() != null) {
            visitLogRepository.findById(alert.getVisitLog().getId())
                    .orElseThrow(() -> new IllegalArgumentException("VisitLog not found"));
        }
        return alertNotificationRepository.save(alert);
    }

    @Override
    public void deleteAlert(Long id) {
        alertNotificationRepository.deleteById(id);
    }
}
