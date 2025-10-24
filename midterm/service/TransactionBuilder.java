package service;

import model.*;
import java.time.LocalDate;
import java.util.UUID;

public class TransactionBuilder {
    
    private RTransactionType transactionType;
    private Customer oldCustomer;
    private Customer nextCustomer;
    private Vehicle vehicle;
    private Registration currRegistration;
    private String customPlate;

    public TransactionBuilder type(RTransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public TransactionBuilder oldCustomer(Customer oldCustomer) {
        this.oldCustomer = oldCustomer;
        return this;
    }

    public TransactionBuilder nextCustomer(Customer nextCustomer) {
        this.nextCustomer = nextCustomer;
        return this;
    }

    public TransactionBuilder vehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public TransactionBuilder registration(Registration currRegistration) {
        this.currRegistration = currRegistration;
        return this;
    }

    public TransactionBuilder withCustomPlate(String customPlate) {
        this.customPlate = customPlate;
        return this;
    }

    public RTransaction build() {
        RTransaction rtx = new RTransaction();
        rtx.setTransactionId(UUID.randomUUID().toString());
        rtx.setRTransactionType(transactionType);
        rtx.setCustomer(nextCustomer == null ? oldCustomer : nextCustomer);
        rtx.setVehicle(vehicle);
        rtx.setRegistration(currRegistration);
        rtx.setDate(LocalDate.now());
        rtx.setFee(0);
        rtx.setCustomPlate(customPlate);
        return rtx;
    }
}