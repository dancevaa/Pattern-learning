package com.danceva.patternlearning.behavioral.chainofresponsibility.dto;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record EntityToProcess(String name, String surname, LocalDate dateOfBirth, String location) {
}
