package model;
/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public class Business extends Customer {

    private String EIN;

    public Business(String name, String streetAddress, String city, State state, String zip, String county, boolean addressChanged, boolean appointment, String EIN) {
        super(name, streetAddress, city, state, zip, county, addressChanged, appointment);
        this.EIN = EIN;
    }

    public String getEIN() {
        return EIN;
    }

    public void setEIN(String EIN) {
        this.EIN = EIN;
    }
}