package service;
import model.Motorcycle;
import model.RTransaction;

/**
 * source: https://www.nj.gov/mvc/vehicles/regfees.htm
 */
public class MotorcycleFeeRule implements FeeRule {

    public boolean appliesTo(RTransaction rtx) {
        return rtx.getVehicle() instanceof Motorcycle;
    }

    public double calculate(RTransaction rtx) {
        return 65.0;
    }
}