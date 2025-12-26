package com.example.demo.controller;

import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/host/{hostId}")
    public List<Appointment> getByHost(@PathVariable Long hostId) {
        return appointmentService.getByHost(hostId);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<Appointment> getByVisitor(@PathVariable Long visitorId) {
        return appointmentService.getByVisitor(visitorId);
    }
}
