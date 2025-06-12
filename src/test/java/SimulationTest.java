//package com.example.ferry.test;
//
//import com.example.ferry.config.AppConfig;
//import com.example.ferry.model.*;
//import org.junit.jupiter.api.*;
//
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class SimulationTest {
//
//    @Test
//    public void testAppConfigLoad() {
//        AppConfig config = AppConfig.getInstance();
//        assertEquals(100.0, config.getFerryArea());
//        assertEquals(20000.0, config.getFerryWeight());
//        assertEquals(4, config.getPassengerCount());
//        assertEquals(3, config.getCargoCount());
//        assertEquals(7, config.getPassengerPriority());
//        assertEquals(5, config.getCargoPriority());
//    }
//
//    @Test
//    public void testPriorityOrdering() {
//        Ferry ferry = Ferry.getInstance(100.0, 20000.0);
//
//        List<Vehicle> vehicles = new ArrayList<>();
//        vehicles.add(new CargoVehicle(ferry, 5));
//        vehicles.add(new PassengerVehicle(ferry, 7));
//        vehicles.add(new PassengerVehicle(ferry, 7));
//        vehicles.add(new CargoVehicle(ferry, 5));
//
//        vehicles.sort(Comparator.naturalOrder());
//
//        assertTrue(vehicles.get(0) instanceof PassengerVehicle);
//        assertEquals(7, vehicles.get(0).getPriority());
//        assertTrue(vehicles.get(vehicles.size() - 1) instanceof CargoVehicle);
//    }
//
//    @Test
//    public void testFerryCapacity() throws InterruptedException {
//        Ferry ferry = Ferry.getInstance(100.0, 20000.0);
//
//        Vehicle p1 = new PassengerVehicle(ferry, 7);
//        Vehicle p2 = new PassengerVehicle(ferry, 7);
//        Vehicle c1 = new CargoVehicle(ferry, 5);
//
//        ferry.boardVehicle(p1);
//        ferry.boardVehicle(p2);
//        ferry.boardVehicle(c1);
//
//        ferry.disembarkVehicle(p1);
//        ferry.disembarkVehicle(p2);
//        ferry.disembarkVehicle(c1);
//
//        // Если метод выполнен без блокировки или ошибки — тест прошёл.
//        assertTrue(true);
//    }
//}
