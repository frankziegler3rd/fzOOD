package service;
import model.RTransaction;

/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

public interface FeeRule {

    boolean appliesTo(RTransaction transaction);
    double calculate(RTransaction transaction);
}