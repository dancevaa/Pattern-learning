package com.danceva.patternlearning.behavioral.chainofresponsibility.service;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.danceva.patternlearning.behavioral.chainofresponsibility.dto.EntityToProcess;
import com.danceva.patternlearning.behavioral.chainofresponsibility.processor.BrestCityProcessorImpl;
import com.danceva.patternlearning.behavioral.chainofresponsibility.processor.DateOfBirthProcessorImpl;
import com.danceva.patternlearning.behavioral.chainofresponsibility.processor.Processor;

class ChainOfResponsibilityServiceTest {

    private ChainOfResponsibilityService service;
    private final Clock clock = new FakeClock();

    private final List<Processor> processorList =
            List.of(new BrestCityProcessorImpl(), new DateOfBirthProcessorImpl(clock));

    @BeforeEach
    void setUp() {
        service = new ChainOfResponsibilityService(processorList);
    }

    @Test
    void shouldInvokeAllProcessors() {

        final EntityToProcess entity = EntityToProcess.builder()
                .name("Vasiliy")
                .surname("Zaytsev")
                .dateOfBirth(LocalDate.parse("1980-01-01"))
                .location("Brest")
                .build();

        service.demonstrate(entity);
    }

    @Test
    void shouldInvokeOnlyDateOfBirthProcessor() {

        final EntityToProcess entity = EntityToProcess.builder()
                .name("Vasiliy")
                .surname("Zaytsev")
                .dateOfBirth(LocalDate.parse("1980-01-01"))
                .location("Minsk")
                .build();

        service.demonstrate(entity);
    }
}