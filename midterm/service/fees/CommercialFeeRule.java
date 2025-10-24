/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package service.fees;

import model.RTransaction;
import model.Commercial;

public class CommercialFeeRule implements FeeRule {
    
    public boolean appliesTo(RTransaction rtx) {
        return rtx.getVehicle() instanceof Commercial;
    }

    public double calculate(RTransaction rtx) {
        return 100;
    }
}