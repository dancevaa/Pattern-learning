package com.danceva.patternlearning.behavioral.chainofresponsibility.processor;

import com.danceva.patternlearning.behavioral.chainofresponsibility.dto.EntityToProcess;

public interface Processor {

    void handle(EntityToProcess entity);

    boolean isApplicable(EntityToProcess entity);
}
