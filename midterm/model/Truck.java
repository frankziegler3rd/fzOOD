/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package model;

public class Truck extends Vehicle {

    private int numWheels;
    private String VIN;

    public Truck(String make, String model, int year, String color, int odometer, FuelType fuelType, String licensePlate, double gvwr, int numWheels, String VIN) {
        super(make, model, year, color, odometer, fuelType, licensePlate, gvwr);
        this.numWheels = numWheels;
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