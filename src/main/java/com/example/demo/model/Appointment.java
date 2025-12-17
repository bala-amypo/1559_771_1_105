package com.example.visitor.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {
   
    private Long id;
    private Visitor visitor;
    private Host host;
    private LocalDate appointmentDate;
    private String purpose;
    private String status = "SCHEDULED";

    public Appointment() {}

    public Appointment(Visitor visitor, Host host, LocalDate appointmentDate, String purpose) {
        this.visitor = visitor;
        this.host = host;
        this.appointmentDate = appointmentDate;
        this.purpose = purpose;
        this.status = "SCHEDULED";
    }

    
  
       


    public Long getId() { return id; }
    public Visitor getVisitor() { return visitor; }
    public void setVisitor(Visitor visitor) { this.visitor = visitor; }
    public Host getHost() { return host; }
    public void setHost(Host host) { this.host = host; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
