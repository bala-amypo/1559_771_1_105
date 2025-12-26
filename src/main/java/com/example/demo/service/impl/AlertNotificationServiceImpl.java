package com.example.demo.service.impl;

import com.example.demo.model.AlertNotification;
import com.example.demo.repository.AlertNotificationRepository;
import com.example.demo.service.AlertNotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private final AlertNotificationRepository repository;

    public AlertNotificationServiceImpl(AlertNotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlertNotification save(AlertNotification alertNotification) {
        return repository.save(alertNotification);
    }

    @Override
    public List<AlertNotification> findAll() {
        return repository.findAll();
    }
}
