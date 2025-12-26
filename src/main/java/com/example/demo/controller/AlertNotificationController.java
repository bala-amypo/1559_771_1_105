package com.example.demo.controller;

import com.example.demo.model.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertNotificationController {

    private final AlertNotificationService alertService;

    public AlertNotificationController(AlertNotificationService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/{visitLogId}")
    public ResponseEntity<AlertNotification> sendAlert(@PathVariable Long visitLogId) {
        return ResponseEntity.ok(alertService.sendAlert(visitLogId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertNotification> getAlert(@PathVariable Long id) {
        return ResponseEntity.ok(alertService.getAlert(id));
    }

    @GetMapping
    public ResponseEntity<List<AlertNotification>> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }
}
