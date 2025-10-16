/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

import java.util.UUID;
import java.time.LocalDate;

public class Transaction {

    private String transactionId;
    private TransactionType transactionType;
    private Customer customer;
    private Vehicle vehicle;
    private Registration registration;
    private LocalDate dateInit;
    private LocalDate dateCompleted;

    public Transaction(String transactionId, TransactionType transactionType, Customer customer, Vehicle vehicle, Registration registration, LocalDate dateInit, LocalDate dateCompleted) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.customer = customer;
        this.vehicle = vehicle;
        this.registration = registration;
        this.dateInit = dateInit;
        this.dateCompleted = dateCompleted;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
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

    public LocalDate getDateInit() {
        return dateInit;
    }

    public void setDateInit(LocalDate dateInit) {
        this.dateInit = dateInit;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}