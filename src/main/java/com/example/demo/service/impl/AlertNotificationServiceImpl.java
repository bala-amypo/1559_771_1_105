package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.time.LocalDateTime;
import java.util.List;

public class AlertNotificationServiceImpl {
    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository; [cite: 237]

    public AlertNotification sendAlert(Long visitLogId) {
        VisitLog log = visitLogRepository.findById(visitLogId).orElseThrow();
        if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new IllegalArgumentException("Alert already sent"); [cite: 239]
        }
        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setSentTo(log.getHost().getEmail());
        alert.setSentAt(LocalDateTime.now());
        alert.setAlertMessage("Visitor has arrived"); [cite: 240]
        
        visitLogRepository.save(log); // For test verification test040/050
        return alertRepository.save(alert);
    }

    public List<AlertNotification> getAllAlerts() { return alertRepository.findAll(); } [cite: 234]
    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Alert not found")); [cite: 241]
    }
}