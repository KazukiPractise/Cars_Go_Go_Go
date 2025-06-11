package com.example.ferry.state;

import com.example.ferry.model.Vehicle;

public class WaitingState implements VehicleState {
    public void handle(Vehicle vehicle) {
        vehicle.setState(new BoardedState());
    }

    public String getStateName() {
        return "Waiting";
    }
}
