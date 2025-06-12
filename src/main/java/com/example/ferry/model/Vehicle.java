package com.example.ferry.model;

import com.example.ferry.state.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public abstract class Vehicle implements Callable<Void> {
    private VehicleState state;
    private static final Logger logger = LogManager.getLogger(Vehicle.class);

    public Vehicle() {
        this.state = new WaitingState();
    }

    @Override
    public Void call() throws Exception {
        Ferry ferry = Ferry.getInstance();

        logger.info("[{}][Thread-{}] State: {}", this.getClass().getSimpleName(),
                Thread.currentThread().getId(), state.getStateName());

        ferry.boardVehicle(this);
        transitionState(); // Boarded

        logger.info("[{}][Thread-{}] State: {}", this.getClass().getSimpleName(),
                Thread.currentThread().getId(), state.getStateName());

        TimeUnit.SECONDS.sleep(1);

        transitionState(); // Crossing

        logger.info("[{}][Thread-{}] State: {}", this.getClass().getSimpleName(),
                Thread.currentThread().getId(), state.getStateName());

        ferry.disembarkVehicle(this);
        transitionState(); // Done

        logger.info("[{}][Thread-{}] State: {}", this.getClass().getSimpleName(),
                Thread.currentThread().getId(), state.getStateName());

        return null;
    }

    public void setState(VehicleState state) {
        this.state = state;
    }

    public void transitionState() {
        this.state.handle(this);
    }

    public abstract double getArea();

    public abstract double getWeight();
}
