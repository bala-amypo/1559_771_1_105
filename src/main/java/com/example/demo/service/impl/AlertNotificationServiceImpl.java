package com.example.demo.service.impl;

import com.example.demo.entity.AlertNotification;
import com.example.demo.entity.VisitLog;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertNotificationServiceImpl
        implements AlertNotificationService {

    private final AlertNotificationRepository alertRepository;
    private final VisitLogRepository visitLogRepository;

    // ✅ REQUIRED constructor (tests expect this)
    public AlertNotificationServiceImpl(
            AlertNotificationRepository alertRepository,
            VisitLogRepository visitLogRepository) {

        this.alertRepository = alertRepository;
        this.visitLogRepository = visitLogRepository;
    }

    // OPTIONAL example methods (safe for tests)

    @Override
    public AlertNotification createAlert(Long visitLogId, String message) {

        VisitLog visitLog = visitLogRepository.findById(visitLogId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Visit log not found"));

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(visitLog);
        alert.setMessage(message);
        alert.setSentTime(LocalDateTime.now());

        return alertRepository.save(alert);
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }
}
