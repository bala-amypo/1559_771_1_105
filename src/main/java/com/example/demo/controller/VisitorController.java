package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.impl.VisitorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@Tag(name = "Visitors", description = "Visitor management endpoints")
public class VisitorController {

    private final VisitorServiceImpl visitorService;

    public VisitorController(VisitorServiceImpl visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    @Operation(summary = "Create a new visitor")
    public ResponseEntity<Visitor> createVisitor(@RequestBody Visitor visitor) {
        Visitor createdVisitor = visitorService.createVisitor(visitor);
        return new ResponseEntity<>(createdVisitor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get visitor by ID")
    public ResponseEntity<Visitor> getVisitor(@PathVariable Long id) {
        return ResponseEntity.ok(visitorService.getVisitor(id));
    }

    @GetMapping
    @Operation(summary = "Get all visitors")
    public ResponseEntity<List<Visitor>> getAllVisitors() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get visitor by email")
    public ResponseEntity<Visitor> getVisitorByEmail(@PathVariable String email) {
        return ResponseEntity.ok(visitorService.getVisitorByEmail(email));
    }
}