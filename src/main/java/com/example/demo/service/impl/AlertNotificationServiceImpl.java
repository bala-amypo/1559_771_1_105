package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertNotificationServiceImpl
        implements AlertNotificationService {

    private final AlertNotificationRepository alertRepository;
    private final VisitLogRepository visitLogRepository;

    // ✅ REQUIRED constructor
    public AlertNotificationServiceImpl(
            AlertNotificationRepository alertRepository,
            VisitLogRepository visitLogRepository) {

        this.alertRepository = alertRepository;
        this.visitLogRepository = visitLogRepository;
    }

    // ✅ Controller expects this
    @Override
    public AlertNotification sendAlert(Long visitLogId) {

        VisitLog visitLog = visitLogRepository.findById(visitLogId)
                .orElse(null);

        if (visitLog == null) {
            return null;
        }

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(visitLog);

        return alertRepository.save(alert);
    }

    // ✅ Controller expects this
    @Override
    public List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }

    
    @Override
    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id).orElse(null);
    }
}
