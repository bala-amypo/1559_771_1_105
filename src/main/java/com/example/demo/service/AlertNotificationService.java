package com.example.demo.service;

import com.example.demo.model.AlertNotification;
import java.util.List;

public interface AlertNotificationService {

    AlertNotification sendAlert(Long visitLogId);

    List<AlertNotification> getAllAlerts();

    AlertNotification getAlert(Long id);
}
