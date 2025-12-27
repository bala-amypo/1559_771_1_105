package com.example.demo.service.impl;

import com.example.demo.model.VisitLog;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.repository.HostRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitLogServiceImpl {
    private VisitLogRepository visitLogRepository;
    private VisitorRepository visitorRepository;
    private HostRepository hostRepository;

    // Required for AuthTests reflection
    public VisitLogServiceImpl() {}

    public VisitLogServiceImpl(VisitLogRepository vr, VisitorRepository vtr, HostRepository hr) {
        this.visitLogRepository = vr;
        this.visitorRepository = vtr;
        this.hostRepository = hr;
    }

    // Required by AuthTests line 623 and 778
    public VisitLog getVisitLog(long id) {
        return visitLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));
    }

    public VisitLog checkInVisitor(Long visitorId, Long hostId, String purpose) {
        VisitLog log = new VisitLog();
        log.setVisitor(visitorRepository.findById(visitorId)
            .orElseThrow(() -> new ResourceNotFoundException("Visitor not found")));
        log.setHost(hostRepository.findById(hostId)
            .orElseThrow(() -> new ResourceNotFoundException("Host not found")));
        log.setPurpose(purpose);
        log.setCheckInTime(LocalDateTime.now());
        log.setAccessGranted(true);
        return visitLogRepository.save(log);
    }

    public VisitLog checkOutVisitor(Long id) {
        VisitLog log = getVisitLog(id);
        if (log.getCheckInTime() == null) {
            throw new IllegalStateException("Visitor not checked in");
        }
        log.setCheckOutTime(LocalDateTime.now());
        return visitLogRepository.save(log);
    }

    public List<VisitLog> getActiveVisits() {
        return visitLogRepository.findByCheckOutTimeIsNull();
    }
}