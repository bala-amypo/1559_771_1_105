package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.VisitorDTO;
import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/visitors")
@Tag(name = "Visitors", description = "Visitor management endpoints")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    @Operation(summary = "Create visitor")
    public ResponseEntity<ApiResponse> createVisitor(@Valid @RequestBody VisitorDTO dto) {
        Visitor visitor = toEntity(dto);
        Visitor saved = visitorService.createVisitor(visitor);
        return new ResponseEntity<>(
                new ApiResponse(true, "Visitor created successfully", toDTO(saved)),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    @Operation(summary = "Get all visitors")
    public ResponseEntity<ApiResponse> getAllVisitors() {
        List<VisitorDTO> list = visitorService.getAllVisitors()
                .stream().map(this::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse(true, "Visitors fetched successfully", list));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get visitor by ID")
    public ResponseEntity<ApiResponse> getVisitor(@PathVariable Long id) {
        Visitor visitor = visitorService.getVisitor(id);
        return ResponseEntity.ok(new ApiResponse(true, "Visitor fetched successfully", toDTO(visitor)));
    }

    // Mapping helpers
    private VisitorDTO toDTO(Visitor v) {
        return new VisitorDTO(v.getId(), v.getFullName(), v.getEmail(), v.getPhone(), v.getIdProofNumber());
    }

    private Visitor toEntity(VisitorDTO dto) {
        Visitor v = new Visitor();
        v.setId(dto.getId());
        v.setFullName(dto.getFullName());
        v.setEmail(dto.getEmail());
        v.setPhone(dto.getPhone());
        v.setIdProofNumber(dto.getIdProofNumber());
        return v;
    }
}
