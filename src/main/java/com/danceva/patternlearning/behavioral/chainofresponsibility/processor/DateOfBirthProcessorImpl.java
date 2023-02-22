package com.danceva.patternlearning.behavioral.chainofresponsibility.processor;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import com.danceva.patternlearning.behavioral.chainofresponsibility.dto.EntityToProcess;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class DateOfBirthProcessorImpl implements Processor {

    private final Clock clock;

    @Override
    public void handle(final EntityToProcess entity) {

        final int years = Period.between(entity.dateOfBirth(), LocalDate.now(clock))
                .getYears();
        log.info("{} {} is {} years old", entity.name(), entity.surname(), years);
    }

    @Override
    public boolean isApplicable(EntityToProcess entity) {
        return true;
    }
}
