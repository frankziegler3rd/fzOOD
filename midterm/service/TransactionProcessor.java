/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package service;

import model.RTransaction;

public interface TransactionProcessor {
    void updateRecord(RTransaction rtx);
}