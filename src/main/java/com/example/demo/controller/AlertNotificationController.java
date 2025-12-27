package com.example.demo.controller;

import com.example.demo.entity.AlertNotification;
import com.example.demo.service.impl.AlertNotificationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts", description = "Alert notifications to hosts") // Required tag and description [cite: 439]
public class AlertNotificationController {

    private final AlertNotificationServiceImpl alertService;

    public AlertNotificationController(AlertNotificationServiceImpl alertService) {
        this.alertService = alertService;
    }

    /**
     * Create alert notification; prevents duplicate alerts for the same visit log.
     * Throws IllegalArgumentException "Alert already sent" if a duplicate is detected. [cite: 106, 239]
     */
    @PostMapping("/send/{visitLogId}")
    @Operation(summary = "Send an alert for a specific visit")
    public ResponseEntity<AlertNotification> sendAlert(@PathVariable Long visitLogId) {
        AlertNotification alert = alertService.sendAlert(visitLogId);
        return new ResponseEntity<>(alert, HttpStatus.CREATED); // Returns 201 Created [cite: 346]
    }

    /**
     * Retrieve a specific alert by its ID.
     * Throws ResourceNotFoundException "Alert not found" if missing. [cite: 241, 405]
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get alert details by ID")
    public ResponseEntity<AlertNotification> getAlert(@PathVariable Long id) {
        return ResponseEntity.ok(alertService.getAlert(id)); // Returns 200 OK [cite: 352]
    }

    /**
     * Retrieve a list of all alerts sent.
     */
    @GetMapping
    @Operation(summary = "Get all alerts")
    public ResponseEntity<List<AlertNotification>> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts()); // Returns 200 OK [cite: 356]
    }
}