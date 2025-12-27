package com.example.demo.service.impl;

import com.example.demo.entity.Visitor;
import com.example.demo.repository.VisitorRepository;
import java.util.List;

public class VisitorServiceImpl {
    private final VisitorRepository visitorRepository; [cite: 193]

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository; [cite: 192]
    }

    public Visitor createVisitor(Visitor visitor) { return visitorRepository.save(visitor); } [cite: 188]
    public List<Visitor> getAllVisitors() { return visitorRepository.findAll(); } [cite: 190]
    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Visitor not found")); [cite: 194]
    }
}