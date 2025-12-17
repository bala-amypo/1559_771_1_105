package com.example.visitor.service;

import java.util.List;
import com.example.visitor.model.Appointment;
import com.example.visitor.exception.InvalidDateException;

public interface AppointmentService {
    void createAppointment(Long visitorId, Long hostId, Appointment appointment) throws InvalidDateException;
    Appointment getAppointment(Long id);
    List<Appointment> getAppointmentsForHost(Long hostId);
    List<Appointment> getAppointmentsForVisitor(Long visitorId);
}
