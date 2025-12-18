// package com.example.demo.service.impl;

// import com.example.demo.entity.AlertNotification;
// import com.example.demo.entity.VisitLog;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.AlertNotificationRepository;
// import com.example.demo.repository.VisitLogRepository;
// import com.example.demo.service.AlertNotificationService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class AlertNotificationServiceImpl implements AlertNotificationService {

//     private final AlertNotificationRepository alertRepository;
//     private final VisitLogRepository visitLogRepository;

//     public AlertNotificationServiceImpl(AlertNotificationRepository alertRepository,
//                                         VisitLogRepository visitLogRepository) {
//         this.alertRepository = alertRepository;
//         this.visitLogRepository = visitLogRepository;
//     }

//     @Override
//     public AlertNotification sendAlert(Long visitLogId) {
//         visitLogRepository.findById(visitLogId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
//         if (alertRepository.findByVisitLogId(visitLogId).isPresent()) {
//             throw new IllegalArgumentException("Alert already sent");
//         }

//         VisitLog visitLog = visitLogRepository.findById(visitLogId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

//         AlertNotification alert = new AlertNotification();
//         alert.setVisitLog(visitLog);
//         alert.setSentTo(visitLog.getHost().getEmail());
//         alert.setAlertMessage("Alert for visit log ID " + visitLogId);

//         AlertNotification saved = alertRepository.save(alert);
//         visitLog.setAlertSent(true);
//         visitLogRepository.save(visitLog);

//         return saved;
//     }

//     @Override
//     public AlertNotification getAlert(Long id) {
//         return alertRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
//     }

//     @Override
//     public List<AlertNotification> getAllAlerts() {
//         return alertRepository.findAll();
//     }
// }
