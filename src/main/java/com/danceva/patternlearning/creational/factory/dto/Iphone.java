package com.danceva.patternlearning.creational.factory.dto;

public class Iphone implements Phone{
    @Override
    public void call() {
        System.out.println("Iphone is calling");
    }

    @Override
    public void writeMessage() {
        System.out.println("the model of the phone - Iphone");
    }
}
