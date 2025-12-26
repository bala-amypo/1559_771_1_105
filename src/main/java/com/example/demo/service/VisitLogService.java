package com.example.demo.service;

import com.example.demo.model.VisitLog;
import java.util.List;
import java.util.Optional;

public interface VisitLogService {

    VisitLog save(VisitLog visitLog);

    List<VisitLog> findAll();

    Optional<VisitLog> getVisitLog(Long id);

    VisitLog checkOut(Long id);
}
