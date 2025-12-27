package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitLogServiceImpl {
    private VisitLogRepository visitLogRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    public VisitLogServiceImpl(VisitLogRepository vr, VisitorRepository vtr, HostRepository hr) {
        this.visitLogRepository = vr;
        this.visitorRepository = vtr;
        this.hostRepository = hr;
    }

    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        Visitor v = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
        Host h = hostRepository.findById(hostId)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found"));

        VisitLog log = new VisitLog();
        log.setVisitor(v);
        log.setHost(h);
        log.setPurpose(purpose);
        log.setAccessGranted(true);
        return visitLogRepository.save(log);
    }

    public VisitLog checkOutVisitor(Long id) {
        VisitLog log = visitLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));
        
        if (log.getCheckInTime() == null) {
            throw new IllegalStateException("Visitor not checked in");
        }
        
        log.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(log);
    }

    public List<VisitLog> getActiveVisits() {
        return visitLogRepository.findByCheckOutTimeIsNull();
    }

    public VisitLog getVisitLog(Long id) {
        return visitLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));
    }
}