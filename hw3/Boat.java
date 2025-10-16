/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public class Boat extends Vehicle {

    private BoatType boatType;
    private int boatLen;
    private Propulsion propulsion;
    private String HIN;

    public Boat(String make, String model, int year, String color, int odometer, int numAxles, FuelType fuelType, LicensePlate licensePlate, double gvwr, BoatType boatType, int boatLen, Propulsion propulsion, String HIN) {
        super(make, model, year, color, odometer, numAxles, fuelType, licensePlate, gvwr);
        this.boatType = boatType;
        this.boatLen = boatLen;
        this.propulsion = propulsion;
        this.HIN = HIN;
    }

    public BoatType getBoatType() {
        return boatType;
    }

    public void setBoatType(BoatType boatType) {
        this.boatType = boatType;
    }

    public int getBoatLen() {
        return boatLen;
    }

    public void setBoatLen(int boatLen) {
        this.boatLen = boatLen;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(Propulsion propulsion) {
        this.propulsion = propulsion;
    }

    public String getHIN() {
        return HIN;
    }

    public void setHIN(String HIN) {
        this.HIN = HIN;
    }    
}