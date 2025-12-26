package com.example.demo.service.impl;

import com.example.demo.model.VisitLog;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.service.VisitLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VisitLogServiceImpl implements VisitLogService {

    private final VisitLogRepository repository;

    public VisitLogServiceImpl(VisitLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public VisitLog save(VisitLog visitLog) {
        return repository.save(visitLog);
    }

    @Override
    public List<VisitLog> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<VisitLog> getVisitLog(Long id) {
        return repository.findById(id);
    }

    @Override
    public VisitLog checkOut(Long id) {
        VisitLog log = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
        log.setCheckOutTime(LocalDateTime.now());
        return repository.save(log);
    }
}
