package service;

import model.Boat;
import model.Vehicle;
import model.RTransaction;

/**
 * source: https://www.nj.gov/mvc/vehicles/regfees.htm
 */
public class BoatFeeRule implements FeeRule {
    
    public boolean appliesTo(RTransaction rtx) {
        return rtx.getVehicle() instanceof Boat;
    }

    public double calculate(RTransaction rtx) {
        Boat rtxb = (Boat) rtx.getVehicle();
        int boatLenInInches = rtxb.getBoatLen();
        double boatLenFt = boatLenInInches / 12;
        double fee = 0.0;
        if (boatLenFt < 16) fee = 12.0;
        if (boatLenFt >= 16 && boatLenFt < 26) fee = 28.0;
        if (boatLenFt >= 26 && boatLenFt < 40) fee = 52.0;
        if (boatLenFt >= 40 && boatLenFt < 65) fee = 80.0;
        if (boatLenFt >= 65) fee = 250.0;
        return fee;
    }
}