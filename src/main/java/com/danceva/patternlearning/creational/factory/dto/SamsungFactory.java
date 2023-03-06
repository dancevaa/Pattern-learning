package com.danceva.patternlearning.creational.factory.dto;

public class SamsungFactory implements PhoneFactory{
    @Override
    public Phone createPhone() {
        return new Samsung();
    }
}
