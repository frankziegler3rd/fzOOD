package service;
import model.RTransaction;

public interface TransactionProcessor {
    void updateRecord(RTransaction rtx);
}