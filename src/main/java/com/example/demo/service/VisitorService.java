package com.example.demo.service;

import com.example.demo.model.Visitor;
import java.util.List;

public interface VisitorService {

    Visitor createVisitor(Visitor visitor);

    List<Visitor> getAllVisitors();

    Visitor getVisitorById(Long id);

    Visitor updateVisitor(Long id, Visitor visitor);

    void deleteVisitor(Long id);
}
