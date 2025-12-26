package com.example.demo.service;

import com.example.demo.model.VisitLog;

import java.util.List;
import java.util.Optional;

public interface VisitLogService {
    List<VisitLog> getAllLogs();
    Optional<VisitLog> getVisitLog(Long id); // required method
    VisitLog saveLog(VisitLog log);
    void deleteLog(Long id);
    void logVisit(String details); // required method
}
