package com.example.demo.controller;

import com.example.demo.entity.VisitLog;
import com.example.demo.service.impl.VisitLogServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/visits")
@Tag(name = "Visit Logs", description = "Check-in and check-out operations") // [cite: 438]
public class VisitLogController {
    private final VisitLogServiceImpl visitLogService;

    public VisitLogController(VisitLogServiceImpl visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}") // [cite: 321]
    public ResponseEntity<VisitLog> checkIn(@PathVariable Long visitorId, @PathVariable Long hostId, @RequestBody String purpose) {
        return new ResponseEntity<>(visitLogService.checkInVisitor(visitorId, hostId, purpose), HttpStatus.CREATED);
    }

    @PostMapping("/checkout/{visitLogId}") // [cite: 327]
    public ResponseEntity<VisitLog> checkOut(@PathVariable Long visitLogId) {
        return ResponseEntity.ok(visitLogService.checkOutVisitor(visitLogId));
    }

    @GetMapping("/active") // [cite: 333]
    public ResponseEntity<List<VisitLog>> getActive() {
        return ResponseEntity.ok(visitLogService.getActiveVisits());
    }
}