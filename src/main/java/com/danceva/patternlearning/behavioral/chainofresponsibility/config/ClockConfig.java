package com.danceva.patternlearning.behavioral.chainofresponsibility.config;

import static java.time.Clock.systemDefaultZone;

import java.time.Clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClockConfig {

    @Bean
    Clock defaultClock() {
        return systemDefaultZone();
    }
}
