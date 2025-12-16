package com.example.demo.model


public class Appointment{
    private Long id;
    private Visitor visitor;
    private Host host;
    private LocalDate appointmentDate;
    private String purpose;
    private String status;


    public Appointment () {}
}