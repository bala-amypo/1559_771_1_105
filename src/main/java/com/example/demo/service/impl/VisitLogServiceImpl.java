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
    public List<VisitLog> getAllLogs() {
        return visitLogRepository.findAll();
    }

    @Override
    public Optional<VisitLog> getVisitLog(Long id) {
        return visitLogRepository.findById(id);
    }

    @Override
    public VisitLog saveLog(VisitLog log) {
        Visitor visitor = visitorRepository.findById(log.getVisitor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Visitor not found"));
        log.setVisitor(visitor);
        return visitLogRepository.save(log);
    }

    @Override
    public void deleteLog(Long id) {
        visitLogRepository.deleteById(id);
    }

    @Override
    public void logVisit(String details) {
        System.out.println("Logging visit: " + details);
    }
}
