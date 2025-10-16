/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public class Car extends Vehicle {

    private int numWheels;
    private String VIN;

    public Car(String make, String model, int year, String color, int odometer, int numAxles, FuelType fuelType, LicensePlate licensePlate, double gvwr, String VIN) {
        super(make, model, year, color, odometer, numAxles, fuelType, licensePlate, gvwr);
        numWheels = 4;
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