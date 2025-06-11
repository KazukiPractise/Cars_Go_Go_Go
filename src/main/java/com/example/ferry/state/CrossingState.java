package com.example.ferry.state;

import com.example.ferry.model.Vehicle;

public class CrossingState implements VehicleState {
    public void handle(Vehicle vehicle) {
        vehicle.setState(new DoneState());
    }

    public String getStateName() {
        return "Crossing";
    }
}
