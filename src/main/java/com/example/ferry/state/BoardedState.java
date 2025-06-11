package com.example.ferry.state;

import com.example.ferry.model.Vehicle;

public class BoardedState implements VehicleState {
    public void handle(Vehicle vehicle) {
        vehicle.setState(new CrossingState());
    }

    public String getStateName() {
        return "Boarded";
    }
}
