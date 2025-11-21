/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package service;

import model.*;
import java.util.List;

public class ServiceProxy implements IUserOps, IAccountOps {

    private final UserService us;
    private final AccountService as;

    public ServiceProxy() {
        us = new UserService();
        as = new AccountService();
    }

    public boolean register(User user) {
        return us.register(user);
    }

    public boolean login(String username, String password) {
        return us.login(username, password);
    }

    public boolean createAccount(Account account) {
        return as.createAccount(account);
    }

    public boolean deleteAccount(String accountNumber) {
        return as.deleteAccount(accountNumber);
    }

    public List<Account> getUserAccountsByUsername(String username) {
        return as.getUserAccountsByUsername(username);
    }

    public boolean withdraw(String accountNumber, double amount) {
        return as.withdraw(accountNumber, amount);
    }

    public boolean deposit(String accountNumber, double amount) {
        return as.deposit(accountNumber, amount);
    }

    public boolean zelleSend(String sourceUsername, String phoneNumber, String email, double amount) {
        return as.zelleSend(sourceUsername, phoneNumber, email, amount);
    }
}
