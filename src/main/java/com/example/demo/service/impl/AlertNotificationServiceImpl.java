package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository alertRepository;
    private final VisitLogRepository visitLogRepository;

    // ✅ Constructor used by Spring
    public AlertNotificationServiceImpl(AlertNotificationRepository alertRepository,
                                        VisitLogRepository visitLogRepository) {
        this.alertRepository = alertRepository;
        this.visitLogRepository = visitLogRepository;
    }

    // ✅ No‑args constructor for tests
    public AlertNotificationServiceImpl() {
        this.alertRepository = null;
        this.visitLogRepository = null;
    }

    @Override
    public AlertNotification sendAlert(Long visitLogId) {
        if (visitLogRepository == null || alertRepository == null) {
            throw new IllegalStateException("Repositories not initialized");
        }

        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("Visit log not found"));

        alertRepository.findByVisitLogId(visitLogId).ifPresent(a -> {
            throw new IllegalArgumentException("Alert already sent");
        });

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setSentTo(log.getHost().getEmail());
        alert.setAlertMessage("Visitor " + log.getVisitor().getFullName() +
                " has checked in to meet " + log.getHost().getHostName());

        return alertRepository.save(alert);
    }

    @Override
    public AlertNotification getAlert(Long id) {
        if (alertRepository == null) {
            throw new IllegalStateException("Repository not initialized");
        }
        return alertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
    }

    @Override
    public List<AlertNotification> getAllAlerts() {
        if (alertRepository == null) {
            throw new IllegalStateException("Repository not initialized");
        }
        return alertRepository.findAll();
    }
}
