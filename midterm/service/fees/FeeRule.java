/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package service.fees;

import model.RTransaction;

public interface FeeRule {

    boolean appliesTo(RTransaction transaction);
    double calculate(RTransaction transaction);
}