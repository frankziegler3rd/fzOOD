package model;
/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public class Motorcycle extends Vehicle {

    private int numWheels;
    private String VIN;

    public Motorcycle(String make, String model, int year, String color, int odometer, FuelType fuelType, String licensePlate, double gvwr, String VIN) {
        super(make, model, year, color, odometer, fuelType, licensePlate, gvwr);
        numWheels = 2;
        this.VIN = VIN;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
}