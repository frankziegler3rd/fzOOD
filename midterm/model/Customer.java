package model;
/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public abstract class Customer {

    private String name;
    private String streetAddress;
    private String city;
    private State state;
    private String zip;
    private String county;
    private boolean addressChanged;
    private boolean hasAppointment;

    public Customer(String name, String streetAddress, String city, State state, String zip, String county, boolean addressChanged, boolean hasAppointment) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.county = county;
        this.addressChanged = addressChanged;
        this.hasAppointment = hasAppointment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public boolean hasAddressChanged() {
        return addressChanged;
    }

    public void setAddressChanged(boolean addressChanged) {
        this.addressChanged = addressChanged;
    }

    public boolean hasAppointment() {
        return hasAppointment;
    }

    public void setAppointment(boolean hasAppointment) {
        this.hasAppointment = hasAppointment;
    }
}
