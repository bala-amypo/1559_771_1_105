package com.example.demo.controller;

import com.example.demo.model.AlertNotification;
import com.example.demo.service.AlertNotificationService;
import com.example.demo.dto.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts", description = "Alert notifications to hosts")
public class AlertNotificationController {

    private final AlertNotificationService alertService;

    public AlertNotificationController(AlertNotificationService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/send/{visitLogId}")
    public ResponseEntity<ApiResponse> send(@PathVariable Long visitLogId) {
        AlertNotification alert = alertService.sendAlert(visitLogId);
        return ResponseEntity.status(201).body(new ApiResponse(true, "Alert sent", alert));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertNotification> get(@PathVariable Long id) {
        return ResponseEntity.ok(alertService.getAlert(id));
    }

    @GetMapping
    public ResponseEntity<List<AlertNotification>> all() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }
}
