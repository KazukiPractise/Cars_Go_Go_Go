package com.example.ferry.state;

import com.example.ferry.model.Vehicle;

public class DoneState implements VehicleState {
    public void handle(Vehicle vehicle) {
        // End of state
    }

    public String getStateName() {
        return "Done";
    }
}
