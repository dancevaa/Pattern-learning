package com.danceva.patternlearning.behavioral.chainofresponsibility.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.danceva.patternlearning.behavioral.chainofresponsibility.dto.EntityToProcess;
import com.danceva.patternlearning.behavioral.chainofresponsibility.processor.Processor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChainOfResponsibilityService {

    private final List<Processor> processors;

    public void demonstrate(final EntityToProcess entity) {
        processors.stream()
                .filter(processor -> processor.isApplicable(entity))
                .forEach(processor -> processor.handle(entity));
    }
}
