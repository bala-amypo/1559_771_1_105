package com.example.demo.service.impl;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {
        if (visitorRepository.existsByEmail(visitor.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return visitorRepository.save(visitor);
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor getVisitorById(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
    }

    @Override
    public Visitor updateVisitor(Long id, Visitor updatedVisitor) {
        Visitor existing = getVisitorById(id);

        existing.setName(updatedVisitor.getName());
        existing.setEmail(updatedVisitor.getEmail());
        existing.setPhone(updatedVisitor.getPhone());

        return visitorRepository.save(existing);
    }

    @Override
    public void deleteVisitor(Long id) {
        visitorRepository.deleteById(id);
    }
}
