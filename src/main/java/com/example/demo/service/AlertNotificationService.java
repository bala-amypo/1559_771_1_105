package com.example.visitor.service;

import java.util.List;
import com.example.visitor.model.Alert;
import com.example.visitor.exception.DuplicateAlertException;

public interface AlertNotificationService {
    void sendAlert(Long visitLogId) throws DuplicateAlertException;
    Alert getAlert(Long id);
    List<Alert> getAllAlerts();
}
