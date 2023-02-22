package com.danceva.patternlearning.behavioral.chainofresponsibility.dto;

import java.util.Arrays;
import java.util.Optional;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public enum SupportedCities {
    BREST("Brest", "Dzerjinskogo 42");

    private final String cityName;
    private final String officeAddress;

    SupportedCities(String cityName, String officeAddress) {
        this.cityName = cityName;
        this.officeAddress = officeAddress;
    }

    @SneakyThrows
    public String getOfficeAddressByCity(final String cityName) {
        final Optional<SupportedCities> city = Arrays.stream(SupportedCities.values())
                .filter(supportedCities -> supportedCities.getCityName()
                        .equals(cityName))
                .findFirst();
        if (city.isPresent()) {
            return city.get().getCityName();
        } else {
            throw new Exception("The city [%s] is not supported".formatted(cityName));
        }
    }
}
