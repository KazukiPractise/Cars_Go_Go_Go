package com.example.ferry.state;

import com.example.ferry.model.Vehicle;

public interface VehicleState {
    void handle(Vehicle vehicle);
    String getStateName();
}
