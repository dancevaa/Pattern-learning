package com.danceva.patternlearning.behavioral.chainofresponsibility.processor;

import org.springframework.stereotype.Component;

import com.danceva.patternlearning.behavioral.chainofresponsibility.dto.EntityToProcess;
import com.danceva.patternlearning.behavioral.chainofresponsibility.dto.SupportedCities;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BrestCityProcessorImpl implements Processor {

    @Override
    public void handle(final EntityToProcess entity) {
        log.info("{} {} is from {}. So the nearest office is on the {}", entity.name(),
                entity.surname(), entity.location());
    }

    @Override
    public boolean isApplicable(final EntityToProcess entity) {
        return SupportedCities.BREST.getCityName()
                .equals(entity.location());
    }
}
