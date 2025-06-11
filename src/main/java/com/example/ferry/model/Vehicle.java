package com.example.ferry.model;

import com.example.ferry.state.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public abstract class Vehicle implements Callable<Void> {
    protected final double area;
    protected final double weight;
    protected final Ferry ferry;
    protected VehicleState state;
    private static final Logger logger = LogManager.getLogger(Vehicle.class);

    public Vehicle(double area, double weight, Ferry ferry) {
        this.area = area;
        this.weight = weight;
        this.ferry = ferry;
        this.state = new WaitingState();
    }

    @Override
    public Void call() throws Exception {
        logger.info("{} - State: {}", this.getClass().getSimpleName(), state.getStateName());
        ferry.boardVehicle(this);
        transitionState(); // To Boarded
        logger.info("{} - State: {}", this.getClass().getSimpleName(), state.getStateName());
        TimeUnit.SECONDS.sleep(1);
        transitionState(); // To Crossing
        logger.info("{} - State: {}", this.getClass().getSimpleName(), state.getStateName());
        ferry.disembarkVehicle(this);
        transitionState(); // To Done
        logger.info("{} - State: {}", this.getClass().getSimpleName(), state.getStateName());
        return null;
    }

    public void setState(VehicleState state) {
        this.state = state;
    }

    public void transitionState() {
        this.state.handle(this);
    }

    public double getArea() { return area; }
    public double getWeight() { return weight; }
}
