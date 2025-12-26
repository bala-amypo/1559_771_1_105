package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository;

    public AlertNotification sendAlert(Long visitLogId) {
        VisitLog vl = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));

        Optional<AlertNotification> existing = alertRepository.findByVisitLogId(visitLogId);
        if (existing.isPresent()) throw new IllegalArgumentException("Alert already sent");

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(vl);
        alert.setSentTo(vl.getHost().getEmail());
        alert.setSentAt(LocalDateTime.now());
        alert.setAlertMessage("Visitor " + vl.getVisitor().getFullName() + " checked in");
        vl.setAlertSent(true);
        visitLogRepository.save(vl);
        return alertRepository.save(alert);
    }

    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    public java.util.List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }
}
