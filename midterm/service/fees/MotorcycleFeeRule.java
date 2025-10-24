/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package service.fees;

import model.Motorcycle;
import model.RTransaction;

public class MotorcycleFeeRule implements FeeRule {

    public boolean appliesTo(RTransaction rtx) {
        return rtx.getVehicle() instanceof Motorcycle;
    }

    public double calculate(RTransaction rtx) {
        return 65.0;
    }
}