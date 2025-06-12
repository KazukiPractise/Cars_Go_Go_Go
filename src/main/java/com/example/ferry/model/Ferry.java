package com.example.ferry.model;

import java.util.concurrent.locks.*;

public class Ferry {
    private static Ferry instance;
    private final Lock lock = new ReentrantLock();
    private final Condition spaceAvailable = lock.newCondition();
    private final double maxArea;
    private final double maxWeight;
    private double freeArea;
    private double freeWeight;

    private Ferry(double maxArea, double maxWeight) {
        this.maxArea = maxArea;
        this.maxWeight = maxWeight;
        this.freeArea = maxArea;
        this.freeWeight = maxWeight;
    }

    public static synchronized Ferry getInstance(double maxArea, double maxWeight) {
        if (instance == null) {
            instance = new Ferry(maxArea, maxWeight);
        }
        return instance;
    }

    public static Ferry getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Ferry has not been initialized yet.");
        }
        return instance;
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

    public void reset() {
        lock.lock();
        try {
            freeArea = maxArea;
            freeWeight = maxWeight;
        } finally {
            lock.unlock();
        }
    }
}
