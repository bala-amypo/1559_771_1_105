package com.example.demo.service.impl;

import com.example.demo.model.VisitLog;
import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    private final VisitLogRepository visitLogRepository;
    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitLogServiceImpl(VisitLogRepository visitLogRepository, VisitorRepository visitorRepository) {
        this.visitLogRepository = visitLogRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public VisitLog checkInVisitor(Long visitorId, String location) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
        VisitLog log = new VisitLog();
        log.setVisitor(visitor);
        log.setLocation(location);
        log.setCheckedOut(false);
        return visitLogRepository.save(log);
    }

    @Override
    public VisitLog checkOutVisitor(Long visitId) {
        VisitLog log = visitLogRepository.findById(visitId)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
        log.setCheckedOut(true);
        return visitLogRepository.save(log);
    }

    @Override
    public List<VisitLog> getActiveVisits() {
        return visitLogRepository.findByCheckedOutFalse();
    }

    @Override
    public Optional<VisitLog> getVisitLog(Long id) {
        return visitLogRepository.findById(id);
    }
}
