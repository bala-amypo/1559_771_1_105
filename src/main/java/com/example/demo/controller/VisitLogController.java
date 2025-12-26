package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitLogController {

    private final VisitLogService visitLogService;

    @Autowired
    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/checkin")
    public ResponseEntity<VisitLog> checkIn(@RequestParam Long visitorId, @RequestParam String location) {
        return ResponseEntity.ok(visitLogService.checkInVisitor(visitorId, location));
    }

    @PostMapping("/checkout")
    public ResponseEntity<VisitLog> checkOut(@RequestParam Long visitId) {
        return ResponseEntity.ok(visitLogService.checkOutVisitor(visitId));
    }

    @GetMapping("/active")
    public ResponseEntity<List<VisitLog>> getActiveVisits() {
        return ResponseEntity.ok(visitLogService.getActiveVisits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> getVisitLog(@PathVariable Long id) {
        VisitLog log = visitLogService.getVisitLog(id)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
        return ResponseEntity.ok(log);
    }
}
