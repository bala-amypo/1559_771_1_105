package com.example.demo.controller;

import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/{visitorId}/{hostId}")
    public ResponseEntity<Appointment> createAppointment(@PathVariable Long visitorId,
                                                         @PathVariable Long hostId,
                                                         @RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.createAppointment(visitorId, hostId, appointment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointment(id));
    }

    @GetMapping("/host/{hostId}")
    public ResponseEntity<List<Appointment>> getByHost(@PathVariable Long hostId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForHost(hostId));
    }

    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<Appointment>> getByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForVisitor(visitorId));
    }
}
