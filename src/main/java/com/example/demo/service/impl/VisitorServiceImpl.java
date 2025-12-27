package com.example.demo.service.impl;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisitorServiceImpl {
    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    // ADD THIS METHOD TO FIX THE COMPILATION ERROR
    public Visitor getVisitorByEmail(String email) {
        return visitorRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
    }
}