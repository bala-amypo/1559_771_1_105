package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/visit-logs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping
    public VisitLog createLog(@RequestBody VisitLog visitLog) {
        return visitLogService.save(visitLog);
    }

    @GetMapping
    public List<VisitLog> getAllLogs() {
        return visitLogService.findAll();
    }

    @PutMapping("/checkout/{id}")
    public VisitLog checkOut(@PathVariable Long id) {
        return visitLogService.checkOut(id);
    }
}
