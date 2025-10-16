/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public interface FeeRule {

    boolean appliesTo(Transaction transaction);
    double calculate(Transaction transaction);
}