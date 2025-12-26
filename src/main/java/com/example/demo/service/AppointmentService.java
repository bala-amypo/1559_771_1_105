package com.example.demo.service;

import com.example.demo.model.Appointment;
import java.util.List;

public interface AppointmentService {

    Appointment save(Appointment appointment);

    List<Appointment> getByHost(Long hostId);

    List<Appointment> getByVisitor(Long visitorId);
}
