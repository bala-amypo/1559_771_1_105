package com.example.demo.service;

import com.example.demo.model.AlertNotification;
import java.util.List;

public interface AlertNotificationService {

    AlertNotification save(AlertNotification alertNotification);

    List<AlertNotification> findAll();
}
