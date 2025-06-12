package com.example.ferry.model;

public class PassengerVehicle extends Vehicle {
    private static final double AREA = 20;
    private static final double WEIGHT = 2000;
    public PassengerVehicle() {
        super();
    }
    public double getArea(){
        return AREA;
    }
    public double getWeight(){
        return WEIGHT;
    }
}
