/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public abstract class TransactionService {

    private FeeCalculator feeCalculator;
    private Transaction transaction;

    public TransactionService(FeeCalculator feeCalculator, Transaction transaction) {
        this.feeCalculator = feeCalculator;
        this.transaction = transaction;
    }

    public FeeCalculator getFeeCalculator() {
        return feeCalculator;
    }

    public void setFeeCalculator(FeeCalculator feeCalculator) {
        this.feeCalculator = feeCalculator;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    

}