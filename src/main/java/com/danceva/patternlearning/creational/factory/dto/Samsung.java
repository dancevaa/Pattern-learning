package com.danceva.patternlearning.creational.factory.dto;

public class Samsung implements Phone{
    @Override
    public void call() {
        System.out.println("Samsung is calling");
    }

    @Override
    public void writeMessage() {
        System.out.println("the model of the phone - Samsung");
    }
}
