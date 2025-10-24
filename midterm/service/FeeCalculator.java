package service;
import model.RTransaction;
import java.util.List;

public class FeeCalculator {
    private final List<FeeRule> feeRules;

    public FeeCalculator(List<FeeRule> feeRules) {
        this.feeRules = feeRules;
    }

    public double calculateFee(RTransaction rtx)  {
        double total = 0;
        for(FeeRule feeRule : feeRules) {
            if (feeRule.appliesTo(rtx)) 
                total += feeRule.calculate(rtx);
        }
        return total;
    }
}