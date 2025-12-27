package com.example.demo.service.impl;

import com.example.demo.entity.VisitLog;
import com.example.demo.entity.Visitor;
import com.example.demo.model.Host;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.repository.HostRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitLogServiceImpl {
    private final VisitLogRepository visitLogRepository; // [cite: 226]
    private final VisitorRepository visitorRepository;   // [cite: 226]
    private final HostRepository hostRepository;         // [cite: 226]

    public VisitLogServiceImpl(VisitLogRepository vr, VisitorRepository vtr, HostRepository hr) {
        this.visitLogRepository = vr;
        this.visitorRepository = vtr;
        this.hostRepository = hr;
    }

    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        Visitor v = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found")); // [cite: 229]
        Host h = hostRepository.findById(hostId)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found")); // [cite: 205]

        VisitLog log = new VisitLog();
        log.setVisitor(v); // [cite: 80]
        log.setHost(h);    // [cite: 81]
        log.setPurpose(purpose); // [cite: 84]
        log.setAccessGranted(true); // [cite: 227]
        return visitLogRepository.save(log);
    }

    public VisitLog checkOutVisitor(Long visitLogId) {
        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));

        if (log.getCheckInTime() == null) {
            throw new IllegalStateException("Visitor not checked in"); // [cite: 91, 228]
        }

        log.setCheckOutTime(LocalDateTime.now()); // [cite: 228]
        return visitLogRepository.save(log);
    }

    public List<VisitLog> getActiveVisits() {
        return visitLogRepository.findByCheckOutTimeIsNull(); // [cite: 172, 222]
    }
}