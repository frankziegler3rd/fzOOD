package service;

import model.Vehicle;
import model.Car;
import model.Truck;
import model.RTransaction;
import java.time.LocalDate;
/**
 * source: https://www.nj.gov/mvc/vehicles/regfees.htm
 */
public class BasicAutomobileFeeRule implements FeeRule {
    
    public boolean appliesTo(RTransaction rtx) {
        Vehicle v = rtx.getVehicle();
        return v instanceof Car || v instanceof Truck;
    }

    public double calculate(RTransaction rtx) {
        Vehicle v = rtx.getVehicle();
        int vyr = v.getYear();
        double vgvwr = v.getGvwr();
        double total = 0;
        if (vyr > 1969) {
            if (vgvwr < 2700.0) total += 35.5;
            else if (vgvwr >= 2700.0 && vgvwr <= 3800.0) total += 44.5;
            else total += 65.5;
        }
        if (vyr > 1970 && vyr < 1980) {
            if (vgvwr < 2700.0) total += 38.5;
            else if (vgvwr >= 2700.0 && vgvwr <= 3800.0) total += 49.5;
            else total += 72.5;
        } 
        if (vyr >= LocalDate.now().minusYears(2).getYear()) {
            if (vgvwr <= 3500.0) total += 59.0;
            else total += 84.0;
        }
        if (vyr < LocalDate.now().minusYears(2).getYear()) {
            if (vgvwr <= 3500.0) total += 46.5;
            else total += 71.5;
        }
        return total;
    }
}