/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package model;

import java.util.UUID;
import java.time.LocalDate;

public class RTransaction {

    private String transactionId;
    private RTransactionType transactionType;
    private Customer customer;
    private Vehicle vehicle;
    private Registration registration;
    private LocalDate date;
    private double fee;
    private String customPlate;

    // no args -- this is what the Builder uses.
    public RTransaction() {}

    // full args -- for testing. 
    public RTransaction(RTransactionType transactionType, Customer customer, Vehicle vehicle, Registration registration, LocalDate date, double fee) {
        transactionId = UUID.randomUUID().toString();
        this.transactionType = transactionType;
        this.customer = customer;
        this.vehicle = vehicle;
        this.registration = registration;
        this.date = date;
        this.fee = fee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public RTransactionType getRTransactionType() {
        return transactionType;
    }

    public void setRTransactionType(RTransactionType transactionType) {
        this.transactionType = transactionType;
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

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getCustomPlate() {
        return customPlate;
    }

    public void setCustomPlate(String customPlate) {
        this.customPlate = customPlate;
    }
}