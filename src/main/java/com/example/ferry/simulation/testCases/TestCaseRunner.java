package com.example.ferry.simulation.testCases;

import com.example.ferry.simulation.Simulation;

public class TestCaseRunner {
    public static void main(String[] args) throws Exception {
        TestData testData = TestData_io.loadFromJson("src/main/java/com/example/ferry/simulation/testCases/TestCase4.dat");
        Simulation.run("TestCase1", testData.passengerCount, testData.cargoCount, testData.maxArea, testData.maxWeight);
    }
}
