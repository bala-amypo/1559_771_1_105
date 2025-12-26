package com.example.demo.service;

import com.example.demo.model.VisitLog;

import java.util.List;
import java.util.Optional;

public interface VisitLogService {
    VisitLog checkInVisitor(Long visitorId, String location);
    VisitLog checkOutVisitor(Long visitId);
    List<VisitLog> getActiveVisits();
    Optional<VisitLog> getVisitLog(Long id);
}
