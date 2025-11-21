/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package service;

import model.Account;
import repo.AccountRepo;
import java.util.UUID;
import java.util.List;

public class AccountService {

    private final AccountRepo ar;

    public AccountService() {
        ar = AccountRepo.getInstance();
    }

    public boolean createAccount(Account account) {
        if(account.getAccountNumber() == null) {
            account.setAccountNumber(UUID.randomUUID().toString());
        }
        return ar.addAccount(account);
    }

    public boolean deleteAccount(String accountNumber) {
        Account account = ar.findByAccountNumber(accountNumber);
        if(account != null) {
            return ar.deleteAccount(account);
        }
        return false;
    }

    public List<Account> getUserAccountsByUsername(String username) {
        return ar.findByUsername(username);
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account account = ar.findByAccountNumber(accountNumber);
        if(account != null) {
            return ar.updateAccountBalance(account, -1 * amount);
        }
        return false;
    }

    public boolean deposit(String accountNumber, double amount) {
        Account account = ar.findByAccountNumber(accountNumber);
        if(account != null) {
            return ar.updateAccountBalance(account, amount);
        }
        return false;
    }

    public boolean zelleSend(String username, String phoneNumber, String email, double amount) {
        ZelleAdapter za = new ZelleAdapter();
        List<Account> sourceUserAccounts = ar.findByUsername(username);
        for(Account account : sourceUserAccounts) {
            if(account.getUseForZelle()) {
                withdraw(account.getAccountNumber(), amount);
                if(phoneNumber != null) {
                    return za.sendPaymentWithUserPhoneNumber(phoneNumber, amount);
                } else if(email != null) {
                    return za.sendPaymentWithUserEmail(email, amount);
                }
            }
        }
        return true;
    }
}
