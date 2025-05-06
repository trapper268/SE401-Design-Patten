package Behavioral.Iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Vehicle {
    private String vehicleId;
    private String type;
    private String licensePlate;
    private int capacity;
    private String manufacturer;

    public Vehicle(String vehicleId, String type, String licensePlate, int capacity, String manufacturer) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.licensePlate = licensePlate;
        this.capacity = capacity;
        this.manufacturer = manufacturer;
    }

    public String getVehicleId() { return vehicleId; }
    public String getType() { return type; }
    public String getLicensePlate() { return licensePlate; }
    public int getCapacity() { return capacity; }
    public String getManufacturer() { return manufacturer; }

    @Override
    public String toString() {
        return type + " - " + licensePlate + " - " + manufacturer;
    }
}

interface VehicleCollection {
    VehicleIterator createIterator();
}

interface VehicleIterator {
    boolean hasNext();
    Vehicle next();
}

class BusCollection implements VehicleCollection {
    private List<Vehicle> buses = new ArrayList<>();

    public void addBus(Vehicle bus) {
        buses.add(bus);
    }

    public List<Vehicle> getBuses() {
        return buses;
    }

    @Override
    public VehicleIterator createIterator() {
        return new BusIterator(buses);
    }
}

class BusIterator implements VehicleIterator {
    private List<Vehicle> buses;
    private int index = 0;

    public BusIterator(List<Vehicle> buses) {
        this.buses = buses;
    }

    @Override
    public boolean hasNext() {
        return index < buses.size();
    }

    @Override
    public Vehicle next() {
        return buses.get(index++);
    }
}

class TruckCollection implements VehicleCollection {
    private List<Vehicle> trucks = new ArrayList<>();

    public void addTruck(Vehicle truck) {
        trucks.add(truck);
    }

    public List<Vehicle> getTrucks() {
        return trucks;
    }

    @Override
    public VehicleIterator createIterator() {
        return new TruckIterator(trucks);
    }
}

class TruckIterator implements VehicleIterator {
    private List<Vehicle> trucks;
    private int index = 0;

    public TruckIterator(List<Vehicle> trucks) {
        this.trucks = trucks;
    }

    @Override
    public boolean hasNext() {
        while (index < trucks.size()) {
            if (trucks.get(index).getCapacity() > 10) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public Vehicle next() {
        return trucks.get(index++);
    }
}

class CarCollection implements VehicleCollection {
    private List<Vehicle> cars = new ArrayList<>();

    public void addCar(Vehicle car) {
        cars.add(car);
    }

    public List<Vehicle> getCars() {
        return cars;
    }

    @Override
    public VehicleIterator createIterator() {
        return new CarIterator(cars);
    }
}

class CarIterator implements VehicleIterator {
    private List<Vehicle> cars;
    private int index = 0;

    public CarIterator(List<Vehicle> cars) {
        this.cars = cars;
        Collections.sort(this.cars, Comparator.comparing(Vehicle::getManufacturer));
    }

    @Override
    public boolean hasNext() {
        return index < cars.size();
    }

    @Override
    public Vehicle next() {
        return cars.get(index++);
    }
}

class TrafficManager {
    public static void printVehicles(VehicleCollection collection) {
        VehicleIterator iterator = collection.createIterator();
        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            System.out.println(vehicle);
        }
    }
}

public class Iterator {
    public static void main(String[] args) {
        BusCollection buses = new BusCollection();
        buses.addBus(new Vehicle("B01", "Bus", "51A-11111", 40, "Hyundai"));
        buses.addBus(new Vehicle("B02", "Bus", "51A-22222", 45, "Mercedes"));

        TruckCollection trucks = new TruckCollection();
        trucks.addTruck(new Vehicle("T01", "Truck", "60C-33333", 8, "Isuzu"));
        trucks.addTruck(new Vehicle("T02", "Truck", "60C-44444", 12, "Hino"));

        CarCollection cars = new CarCollection();
        cars.addCar(new Vehicle("C01", "Car", "30A-55555", 5, "Toyota"));
        cars.addCar(new Vehicle("C02", "Car", "30A-66666", 5, "Ford"));

        System.out.println("Danh sách xe buýt:");
        TrafficManager.printVehicles(buses);

        System.out.println("\nDanh sách xe tải (trên 10 tấn):");
        TrafficManager.printVehicles(trucks);

        System.out.println("\nDanh sách xe tải (trên 10 tấn):");
        TrafficManager.printVehicles(trucks);

        System.out.println("\nDanh sách xe hơi (theo hãng):");
        TrafficManager.printVehicles(cars);
    }
}
