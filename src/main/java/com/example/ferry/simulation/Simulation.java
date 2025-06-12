package com.example.ferry.simulation;

import com.example.ferry.model.*;
import com.example.ferry.simulation.testCases.TestData;
import com.example.ferry.simulation.testCases.TestData_io;

import java.util.concurrent.*;
import java.util.*;

public class Simulation {

    public static void run(String testName, int passengerCount, int cargoCount, double maxArea, double maxWeight) {
        Ferry.getInstance(maxArea, maxWeight); // инициализация Ferry singleton
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < passengerCount; i++) {
            vehicles.add(new PassengerVehicle());
        }

        for (int i = 0; i < cargoCount; i++) {
            vehicles.add(new CargoVehicle());
        }
        List<Future<Void>> futures = new ArrayList<>();
        for (Vehicle v : vehicles) {
            futures.add(executor.submit(v));
        }

        for (Future<Void> f : futures) {
            try {
                f.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        Ferry.getInstance().reset();
        System.out.println("=== Завершён тест: " + testName + " ===\n");
    }
}
