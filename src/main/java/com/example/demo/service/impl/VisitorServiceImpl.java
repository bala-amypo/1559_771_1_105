package com.example.demo.service.impl;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;
import java.util.List;

public class VisitorServiceImpl implements VisitorService {
    private VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}