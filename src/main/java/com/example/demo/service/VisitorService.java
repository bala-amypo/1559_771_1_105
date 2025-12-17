package com.example.visitor.service;

import java.util.List;
import com.example.visitor.model.Visitor;
import com.example.visitor.exception.NotFoundException;

public interface VisitorService {
    void createVisitor(Visitor visitor);
    Visitor getVisitor(Long id) throws NotFoundException;
    List<Visitor> getAllVisitors();
}
