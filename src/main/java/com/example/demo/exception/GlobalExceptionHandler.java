package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles missing entities (Visitor, Host, Appointment, Alert) [cite: 402-405, 418]
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    // Handles validation failures (Past dates, duplicate alerts, invalid checkouts) [cite: 408-411, 419, 420]
    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class, BadRequestException.class})
    public ResponseEntity<Object> handleBadRequest(Exception ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    private ResponseEntity<Object> buildErrorResponse(HttpStatus status, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now()); // [cite: 416]
        body.put("status", status.value()); // [cite: 416]
        body.put("message", message); // [cite: 416]
        return new ResponseEntity<>(body, status);
    }
}