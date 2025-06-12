package com.example.ferry.simulation.testCases;

public class TestData {
    public int passengerCount;
    public int cargoCount;
    public double maxArea;
    public double maxWeight;

    public TestData(int passengerCount, int cargoCount, double maxArea, double maxWeight) {
        this.passengerCount = passengerCount;
        this.cargoCount = cargoCount;
        this.maxArea = maxArea;
        this.maxWeight = maxWeight;
    }

    public TestData() {
    }
}
