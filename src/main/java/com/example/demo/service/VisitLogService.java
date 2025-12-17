package com.example.visitor.service;

import java.util.List;
import com.example.visitor.model.VisitLog;
import com.example.visitor.exception.InvalidStateException;

public interface VisitLogService {
    void checkInVisitor(Long visitorId, Long hostId, String purpose);
    void checkOutVisitor(Long visitLogId) throws InvalidStateException;
    List<VisitLog> getActiveVisits();
    VisitLog getVisitLog(Long id);
}
