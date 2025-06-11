package com.example.ferry.model;

import java.util.concurrent.locks.*;

public class Ferry {
    private final Lock lock = new ReentrantLock();
    private final Condition spaceAvailable = lock.newCondition();
    private double freeArea;
    private double freeWeight;

    public Ferry(double maxArea, double maxWeight) {
        this.freeArea = maxArea;
        this.freeWeight = maxWeight;
    }

    public void boardVehicle(Vehicle v) throws InterruptedException {
        lock.lock();
        try {
            while (v.getArea() > freeArea || v.getWeight() > freeWeight) {
                spaceAvailable.await();
            }
            freeArea -= v.getArea();
            freeWeight -= v.getWeight();
        } finally {
            lock.unlock();
        }
    }

    public void disembarkVehicle(Vehicle v) {
        lock.lock();
        try {
            freeArea += v.getArea();
            freeWeight += v.getWeight();
            spaceAvailable.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
