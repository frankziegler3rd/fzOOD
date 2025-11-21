/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package model;

public class Checking extends Account {

    public Checking(String username, String routingNumber, String accountNumber, double balance) {
        super(username, routingNumber, accountNumber, balance);
    }

    // yeah right now this does nothing. 
    // when i decide to implement logic differentiating this from savings accounts, cds, etc
    // ill let you know
}
