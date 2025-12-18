 package com.example.demo.controller;

// import com.example.demo.dto.ApiResponse;
// import com.example.demo.dto.AlertNotificationDTO;
// import com.example.demo.entity.AlertNotification;
// import com.example.demo.service.AlertNotificationService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.stream.Collectors;

// @RestController
// @RequestMapping("/api/alerts")
// public class AlertNotificationController {

//     private final AlertNotificationService alertService;

//     public AlertNotificationController(AlertNotificationService alertService) {
//         this.alertService = alertService;
//     }

//     @PostMapping("/send/{visitLogId}")
//     public ResponseEntity<ApiResponse> send(@PathVariable Long visitLogId) {

//         AlertNotification alert = alertService.sendAlert(visitLogId);

//         return new ResponseEntity<>(new ApiResponse(true, "Alert sent", toDto(alert)),
//                 HttpStatus.CREATED);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<ApiResponse> getOne(@PathVariable Long id) {
//         AlertNotification alert = alertService.getAlert(id);
//         return ResponseEntity.ok(new ApiResponse(true, "Alert fetched", toDto(alert)));
//     }

//     @GetMapping
//     public ResponseEntity<ApiResponse> getAll() {
//         List<AlertNotificationDTO> list = alertService.getAllAlerts()
//                 .stream().map(this::toDto).collect(Collectors.toList());
//         return ResponseEntity.ok(new ApiResponse(true, "Alerts fetched", list));
//     }

//     private AlertNotificationDTO toDto(AlertNotification a) {
//         AlertNotificationDTO dto = new AlertNotificationDTO();
//         dto.setId(a.getId());
//         dto.setVisitLogId(a.getVisitLog() != null ? a.getVisitLog().getId() : null);
//         dto.setSentTo(a.getSentTo());
//         dto.setAlertMessage(a.getAlertMessage());
//         dto.setSentAt(a.getSentAt());
//         return dto;
//     }
// }
