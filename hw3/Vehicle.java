/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public class Vehicle {

    private String make;
    private String model;
    private int year;
    private String color;
    private int odometer;
    private int numAxles;
    private FuelType fuelType;
    private LicensePlate licensePlate;
    private double gvwr;

    public Vehicle(String make, String model, int year, String color, int odometer, int numAxles, FuelType fuelType, LicensePlate licensePlate, double gvwr) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.odometer = odometer;
        this.numAxles = numAxles;
        this.fuelType = fuelType;
        this.licensePlate = licensePlate;
        this.gvwr = gvwr;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public int getNumAxles() {
        return numAxles;
    }

    public void setNumAxles(int numAxles) {
        this.numAxles = numAxles;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getGvwr() {
        return gvwr;
    }

    public void setGvwr(double gvwr) {
        this.gvwr = gvwr;
    }
}