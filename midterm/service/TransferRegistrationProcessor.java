package service;
import model.Customer;
import model.RTransaction;

public class TransferRegistrationProcessor implements TransactionProcessor {
    
    public void updateRecord(RTransaction rtx) {
        rtx.getRegistration().setCustomer(rtx.getCustomer()); // transaction would have been built with new customer
    }
}