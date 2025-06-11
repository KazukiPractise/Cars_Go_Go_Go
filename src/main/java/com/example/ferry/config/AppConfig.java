package com.example.ferry.config;

import java.util.Properties;
import java.io.InputStream;

public class AppConfig {
    private static volatile AppConfig instance;
    private Properties props = new Properties();

    private AppConfig() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public double getFerryArea() {
        return Double.parseDouble(props.getProperty("ferry.maxArea"));
    }

    public double getFerryWeight() {
        return Double.parseDouble(props.getProperty("ferry.maxWeight"));
    }

    public int getVehicleCount() {
        return Integer.parseInt(props.getProperty("vehicle.total"));
    }

    public double getPassengerArea() {
        return Double.parseDouble(props.getProperty("vehicle.passenger.area"));
    }

    public double getPassengerWeight() {
        return Double.parseDouble(props.getProperty("vehicle.passenger.weight"));
    }

    public double getCargoArea() {
        return Double.parseDouble(props.getProperty("vehicle.cargo.area"));
    }

    public double getCargoWeight() {
        return Double.parseDouble(props.getProperty("vehicle.cargo.weight"));
    }
}
