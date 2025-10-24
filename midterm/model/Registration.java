/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package model;

import java.util.UUID;
import java.time.LocalDate;

public class Registration {
    private String rid;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate issDate;
    private LocalDate expDate;
    private String licensePlate;

    public Registration(String rid, Customer customer, Vehicle vehicle, LocalDate issDate, LocalDate expDate, String licensePlate) {
        this.rid = rid;
        this.customer = customer;
        this.vehicle = vehicle;
        this.issDate = issDate;
        this.expDate = expDate;
        this.licensePlate = licensePlate;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getIssDate() {
        return issDate;
    }

    public void setIssDate(LocalDate issDate) {
        this.issDate = issDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registration ID: " + rid + "\n");
        sb.append("Owner: " + customer.getName() + "\n");
        sb.append("Vehicle: " + vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + "\n");
        sb.append("Issued: " + issDate + "\n");
        sb.append("Expires: " + expDate + "\n");
        sb.append("License plate: " + licensePlate);
        return sb.toString();
    }
}