package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.impl.VisitorServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@Tag(name = "Visitors", description = "Visitor management endpoints") // [cite: 435]
public class VisitorController {
    private final VisitorServiceImpl visitorService;

    public VisitorController(VisitorServiceImpl visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping // [cite: 268]
    public ResponseEntity<Visitor> create(@RequestBody Visitor visitor) {
        return new ResponseEntity<>(visitorService.createVisitor(visitor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // [cite: 277]
    public ResponseEntity<Visitor> getById(@PathVariable Long id) {
        return ResponseEntity.ok(visitorService.getVisitor(id));
    }

    @GetMapping // [cite: 273]
    public ResponseEntity<List<Visitor>> getAll() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }
}