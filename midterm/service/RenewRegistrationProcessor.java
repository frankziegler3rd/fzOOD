/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package service;

import model.RTransaction;
import java.time.LocalDate;

public class RenewRegistrationProcessor implements TransactionProcessor {
    
    public void updateRecord(RTransaction rtx) {
        rtx.getRegistration().setIssDate(LocalDate.now());
        rtx.getRegistration().setExpDate(LocalDate.now().plusYears(1));
    }
}