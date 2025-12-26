package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit-logs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}")
    public ResponseEntity<VisitLog> checkIn(@PathVariable Long visitorId,
                                            @PathVariable Long hostId,
                                            @RequestParam String purpose) {
        return ResponseEntity.ok(visitLogService.checkInVisitor(visitorId, hostId, purpose));
    }

    @PutMapping("/checkout/{id}")
    public ResponseEntity<VisitLog> checkOut(@PathVariable Long id) {
        return ResponseEntity.ok(visitLogService.checkOutVisitor(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> getVisitLog(@PathVariable Long id) {
        return ResponseEntity.ok(visitLogService.getVisitLog(id));
    }

    @GetMapping("/active")
    public ResponseEntity<List<VisitLog>> getActiveVisits() {
        return ResponseEntity.ok(visitLogService.getActiveVisits());
    }
}
