package com.codinggym.springcore.aircrafts;

public abstract class BasicAirplane implements Aircraft {
    private static int distance;

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public void takeFlight() {
        System.out.println("Airplane took a flight");
    }

    public static boolean canFly() {
        return distance <= 4000;
    }
}
