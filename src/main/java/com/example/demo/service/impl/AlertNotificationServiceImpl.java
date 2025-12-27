package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertNotificationServiceImpl {
    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository;

    // Required for AuthTests reflection
    public AlertNotificationServiceImpl() {}

    public AlertNotificationServiceImpl(AlertNotificationRepository ar, VisitLogRepository vr) {
        this.alertRepository = ar;
        this.visitLogRepository = vr;
    }

    public AlertNotification sendAlert(Long visitLogId) {
        if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
            throw new IllegalArgumentException("Alert already sent");
        }
        
        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setSentTo(log.getHost().getEmail());
        alert.setAlertMessage("Visitor " + log.getVisitor().getFullName() + " has arrived.");
        alert.setSentAt(LocalDateTime.now());
        
        return alertRepository.save(alert);
    }

    // Fixed: Added to satisfy AlertNotificationController
    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    }

    public List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }
}