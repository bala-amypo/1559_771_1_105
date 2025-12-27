package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.time.LocalDateTime;
import java.util.List;

public class VisitLogServiceImpl {
    private VisitLogRepository visitLogRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository; [cite: 226]

    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        VisitLog log = new VisitLog();
        log.setVisitor(visitorRepository.findById(visitorId)
            .orElseThrow(() -> new RuntimeException("Visitor not found"))); [cite: 229]
        log.setHost(hostRepository.findById(hostId).orElseThrow());
        log.setPurpose(purpose);
        log.setCheckInTime(LocalDateTime.now());
        log.setAccessGranted(true);
        log.setAlertSent(false); [cite: 227]
        return visitLogRepository.save(log);
    }

    public VisitLog checkOutVisitor(Long visitLogId) {
        VisitLog log = visitLogRepository.findById(visitLogId)
            .orElseThrow(() -> new RuntimeException("VisitLog not found"));
        if (log.getCheckInTime() == null) {
            throw new IllegalStateException("Visitor not checked in"); [cite: 228]
        }
        log.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(log);
    }

    public List<VisitLog> getActiveVisits() { return visitLogRepository.findByCheckOutTimeIsNull(); } [cite: 222]
    public VisitLog getVisitLog(Long id) {
        return visitLogRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("VisitLog not found")); [cite: 223]
    }
}