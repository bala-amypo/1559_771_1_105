package com.example.demo.controller;

import com.example.demo.model.AlertNotification;
import com.example.demo.service.AlertNotificationService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertNotificationController {

    private final AlertNotificationService alertService;

    public AlertNotificationController(
            AlertNotificationService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public AlertNotification sendAlert(
            @RequestBody AlertNotification alert) {
        return alertService.save(alert);
    }

    @GetMapping
    public List<AlertNotification> getAllAlerts() {
        return alertService.findAll();
    }
}
