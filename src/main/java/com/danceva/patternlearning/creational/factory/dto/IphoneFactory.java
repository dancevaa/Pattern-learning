package com.danceva.patternlearning.creational.factory.dto;

public class IphoneFactory implements PhoneFactory{
    @Override
    public Phone createPhone() {
        return new Iphone();
    }
}
