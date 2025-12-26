package com.example.demo.controller;

import com.example.demo.model.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerts")
public class AlertNotificationController {

    private final AlertNotificationService alertNotificationService;

    @Autowired
    public AlertNotificationController(AlertNotificationService alertNotificationService) {
        this.alertNotificationService = alertNotificationService;
    }

    @PostMapping
    public ResponseEntity<String> sendAlert(@RequestParam String message) {
        alertNotificationService.sendAlert(message);
        return ResponseEntity.ok("Alert sent");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertNotification> getAlert(@PathVariable Long id) {
        AlertNotification alert = alertNotificationService.getAlert(id)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
        return ResponseEntity.ok(alert);
    }
}
