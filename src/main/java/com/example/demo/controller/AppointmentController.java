package com.example.demo.controller;

import com.example.demo.model.Appointment;
import com.example.demo.service.impl.AppointmentServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@Tag(name = "Appointments", description = "Appointment scheduling")
public class AppointmentController {
    private final AppointmentServiceImpl appointmentService;

    public AppointmentController(AppointmentServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/{visitorId}/{hostId}")
    public ResponseEntity<Appointment> create(@PathVariable Long visitorId, @PathVariable Long hostId, @RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentService.createAppointment(visitorId, hostId, appointment), HttpStatus.CREATED);
    }

    @GetMapping("/host/{hostId}")
    public ResponseEntity<List<Appointment>> getByHost(@PathVariable Long hostId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForHost(hostId));
    }
}