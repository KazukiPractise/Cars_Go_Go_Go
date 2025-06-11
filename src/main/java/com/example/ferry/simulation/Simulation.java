package com.example.ferry.simulation;

import com.example.ferry.config.AppConfig;
import com.example.ferry.model.*;
import java.util.concurrent.*;
import java.util.*;

public class Simulation {
    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();
        Ferry ferry = new Ferry(config.getFerryArea(), config.getFerryWeight());

        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Void>> futures = new ArrayList<>();

        int totalVehicles = config.getVehicleCount();
        for (int i = 0; i < totalVehicles; i++) {
            Vehicle v = (i % 2 == 0) ?
                new PassengerVehicle(config.getPassengerArea(), config.getPassengerWeight(), ferry) :
                new CargoVehicle(config.getCargoArea(), config.getCargoWeight(), ferry);
            futures.add(executor.submit(v));
        }

        futures.forEach(f -> {
            try { f.get(); } catch (Exception e) { e.printStackTrace(); }
        });

        executor.shutdown();
        System.out.println("All vehicles transported.");
    }
}
