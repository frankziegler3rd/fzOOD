package model;
/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public class Commercial extends Vehicle {

    private int numWheels;
    private String VIN;
    private int seatingCap;
    private CommercialClass commClass;

    public Commercial(String make, String model, int year, String color, int odometer, FuelType fuelType, String licensePlate, double gvwr, int numWheels, String VIN, int seatingCap, int code) {
        super(make, model, year, color, odometer, fuelType, licensePlate, gvwr);
        this.numWheels = numWheels;
        this.seatingCap = seatingCap;
        commClass = CommercialClass.getClassFromCode(code);
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

    public int getSeatingCap() {
        return seatingCap;
    }
}