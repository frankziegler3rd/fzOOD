package model;
/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public class Individual extends Customer {

    private License license;
    private String ssn;
    private boolean sixPointsOfId;

    public Individual(String name, String streetAddress, String city, State state, String zip, String county, boolean addressChanged, boolean appointment, License license, String ssn, boolean sixPointsOfId) {
        super(name, streetAddress, city, state, zip, county, addressChanged, appointment);
        this.license = license;
        this.ssn = ssn;
        this.sixPointsOfId = sixPointsOfId;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getSSN() {
        return ssn;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

    public boolean hasSixPointsOfId() {
        return sixPointsOfId;
    }

    public void setSixPointsOfId(boolean sixPointsOfId) {
        this.sixPointsOfId = sixPointsOfId;
    }
}