package com.example.ferry.model;

public class CargoVehicle extends Vehicle {
    private static final double AREA = 50;
    private static final double WEIGHT = 5000;
    public CargoVehicle() {
        super();
    }
    public double getArea(){
        return AREA;
    }
    public double getWeight(){
        return WEIGHT;
    }
}
