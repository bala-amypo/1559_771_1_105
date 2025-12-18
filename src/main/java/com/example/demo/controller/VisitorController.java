package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.VisitorDTO;
import com.example.demo.entity.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createVisitor(@RequestBody VisitorDTO dto) {

        Visitor visitor = new Visitor();
        visitor.setFullName(dto.getFullName());
        visitor.setEmail(dto.getEmail());
        visitor.setPhone(dto.getPhone());
        visitor.setIdProofNumber(dto.getIdProofNumber());

        Visitor saved = visitorService.createVisitor(visitor);

        return new ResponseEntity<>(new ApiResponse(true, "Visitor created", toDto(saved)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        List<VisitorDTO> list = visitorService.getAllVisitors()
                .stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(new ApiResponse(true, "Visitors fetched", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getOne(@PathVariable Long id) {
        Visitor visitor = visitorService.getVisitor(id);
        return ResponseEntity.ok(new ApiResponse(true, "Visitor fetched", toDto(visitor)));
    }

    private VisitorDTO toDto(Visitor v) {
        VisitorDTO dto = new VisitorDTO();
        dto.setId(v.getId());
        dto.setFullName(v.getFullName());
        dto.setEmail(v.getEmail());
        dto.setPhone(v.getPhone());
        dto.setIdProofNumber(v.getIdProofNumber());
        return dto;
    }
}
