/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package service;

import model.User;
import model.Account;
import java.util.List;
import repo.*;

public class ZelleAdapter {
    
    private final AccountRepo ar;
    private final UserRepo ur;

    public ZelleAdapter() {
        ar = AccountRepo.getInstance();
        ur = UserRepo.getInstance();
    }

    public boolean sendPaymentWithUserPhoneNumber(String phoneNumber, double amount) {
        User targetUser = ur.findByPhoneNumber(phoneNumber);
        if(targetUser != null) {
            List<Account> targetUserAccounts = ar.findByUsername(targetUser.getUsername());
            for(Account account : targetUserAccounts) {
                if(account.getUseForZelle()) {
                    ar.updateAccountBalance(account, amount);
                }
            }
        }
        return true; // adapter assumes that this always works. in the case that the input information is wrong or it belongs to a user outside of the bank, that's not our problem.
    }

    public boolean sendPaymentWithUserEmail(String email, double amount) {
        User targetUser = ur.findByEmail(email);
        if(targetUser != null) {
            List<Account> targetUserAccounts = ar.findByUsername(targetUser.getUsername());
            for(Account account : targetUserAccounts) {
                if(account.getUseForZelle()) {
                    ar.updateAccountBalance(account, amount);
                }
            }
        }
        return true;           
    }
}
