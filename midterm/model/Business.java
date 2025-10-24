/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package model;

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