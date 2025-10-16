/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

import java.util.List;
import java.util.ArrayList;

public class RegistrationFeeCalculator implements FeeCalculator {

    private final List<FeeRule> feeRules;

    public RegistrationFeeCalculator(List<FeeRule> feeRules) {
        this.feeRules = feeRules;
    }

    public double calculateTotal(Transaction transaction) {
        double total = baseFee;
        for (FeeRule feeRule : feeRules) {
            if (feeRule.appliesTo(transaction) {
                total += feeRule.calculate();
            }
        }
        return total;
    }
}