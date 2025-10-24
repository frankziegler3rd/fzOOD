package service;
import model.RTransaction;
import model.FuelType;
/**
 * this is a rudimentary implementation, but to actually flesh out the logic is a shit-ton of work:
 * 
 * "Under New Jersey law effective July 1, 2024, zero emission vehicles (ZEVs) are subject to an annual fee in 
 * addition to the existing registration fee. The additional fee applies to any vehicle certified as a ZEV 
 * pursuant to the California Air Resources Board ZEV standards for the applicable model year. The additional 
 * fee is payable in full at the time of initial registration and at every renewal. Beginning July 1, 2024, the 
 * annual fee is $250. The annual fee increases $10 per year for four years thereafter. For new ZEV registered, 
 * four years of the additional fee is due at the time of four year registration. For example, for new ZEVs 
 * registered between July 1, 2024, and June 30, 2025, the additional fee due and payable at the time of initial 
 * registration is for the years 2024, 2025, 2026 and 2027."
 * 
 * this class only returns $250 as the fee, but it's actually more complex than that. 
 * 
 * source: https://www.nj.gov/mvc/vehicles/regfees.htm
 */
public class ZEVFeeRule implements FeeRule {
    
    public boolean appliesTo(RTransaction rtx) {
        return rtx.getVehicle().getFuelType() == FuelType.ELECTRIC;
    }
    
    public double calculate(RTransaction rtx) {
        return 250.0;
    }
}