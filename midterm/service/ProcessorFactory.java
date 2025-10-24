/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package service;

import model.RTransactionType;

public class ProcessorFactory {
    public static TransactionProcessor getProcessor(RTransactionType tt) {
        switch(tt) {
            case INITIAL:
                return new InitialRegistrationProcessor();
            case RENEWAL:
                return new RenewRegistrationProcessor();
            case TRANSFER:
                return new TransferRegistrationProcessor();
        }
        throw new IllegalArgumentException("Transaction type " + tt + " does not have a handler.");
    }
}