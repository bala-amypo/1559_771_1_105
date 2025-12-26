package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.model.VisitLog;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    // ✅ REQUIRED BY INTERFACE
    @Override
    public AlertNotification getAlert(Long id) {
        return alertRepository.findById(id).orElse(null);
    }
}
