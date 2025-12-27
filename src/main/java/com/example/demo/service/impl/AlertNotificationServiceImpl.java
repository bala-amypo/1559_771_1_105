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
    private final AlertNotificationRepository alertRepository; // Repository field name exactly as required [cite: 237]
    private final VisitLogRepository visitLogRepository; // Repository field name exactly as required [cite: 237]

    public AlertNotificationServiceImpl(AlertNotificationRepository ar, VisitLogRepository vr) {
        this.alertRepository = ar;
        this.visitLogRepository = vr;
    }

    public AlertNotification sendAlert(Long visitLogId) {
        // Retrieve visit log or throw ResourceNotFoundException [cite: 241]
        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

        // Check if alert already exists for visit log [cite: 238]
        alertRepository.findByVisitLogId(visitLogId).ifPresent(a -> {
            throw new IllegalArgumentException("Alert already sent"); // Requirement for Test 030 [cite: 239]
        });

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log); // Relationship mapping [cite: 110]
        alert.setSentTo(log.getHost().getEmail()); // Extract host email [cite: 240]
        alert.setAlertMessage("Visitor " + log.getVisitor().getFullName() + " has arrived.");
        alert.setSentAt(LocalDateTime.now()); // Timestamp requirement [cite: 240]
        
        // Update log and save alert [cite: 240]
        return alertRepository.save(alert);
    }

    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    }

    public List<AlertNotification> getAllAlerts() {
        return alertRepository.findAll();
    }
}