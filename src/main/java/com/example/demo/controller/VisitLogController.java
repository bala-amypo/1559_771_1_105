package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.VisitLogDTO;
import com.example.demo.entity.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/visits")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}")
    public ResponseEntity<ApiResponse> checkIn(@PathVariable Long visitorId,
                                               @PathVariable Long hostId,
                                               @RequestBody String purpose) {

        VisitLog log = visitLogService.checkInVisitor(visitorId, hostId, purpose);

        return new ResponseEntity<>(new ApiResponse(true, "Visitor checked in", toDto(log)),
                HttpStatus.CREATED);
    }

    @PostMapping("/checkout/{visitLogId}")
    public ResponseEntity<ApiResponse> checkOut(@PathVariable Long visitLogId) {
        VisitLog log = visitLogService.checkOutVisitor(visitLogId);
        return ResponseEntity.ok(new ApiResponse(true, "Visitor checked out", toDto(log)));
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse> active() {
        List<VisitLogDTO> list = visitLogService.getActiveVisits()
                .stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse(true, "Active visits", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getOne(@PathVariable Long id) {
        VisitLog log = visitLogService.getVisitLog(id);
        return ResponseEntity.ok(new ApiResponse(true, "Visit log fetched", toDto(log)));
    }

    private VisitLogDTO toDto(VisitLog v) {
        VisitLogDTO dto = new VisitLogDTO();
        dto.setId(v.getId());
        dto.setVisitorId(v.getVisitor() != null ? v.getVisitor().getId() : null);
        dto.setHostId(v.getHost() != null ? v.getHost().getId() : null);
        dto.setCheckInTime(v.getCheckInTime());
        dto.setCheckOutTime(v.getCheckOutTime());
        dto.setPurpose(v.getPurpose());
        dto.setAccessGranted(v.getAccessGranted());
        return dto;
    }
}
