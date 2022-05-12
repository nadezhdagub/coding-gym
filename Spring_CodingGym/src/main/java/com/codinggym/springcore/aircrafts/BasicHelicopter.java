package com.codinggym.springcore.aircrafts;

public abstract class BasicHelicopter implements Aircraft {
    @Override
    public void takeFlight() {
        System.out.println("Helicopter took a flight");
    }
}