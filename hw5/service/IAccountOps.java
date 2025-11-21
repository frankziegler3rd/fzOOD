/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package service;

import model.Account;
import java.util.List;

public interface IAccountOps {
    boolean createAccount(Account account);
    boolean deleteAccount(String accountNumber);
    List<Account> getUserAccountsByUsername(String username);
    boolean withdraw(String accountNumber, double amount);
    boolean deposit(String accountNumber, double amount);
    boolean zelleSend(String sourceUsername, String phoneNumber, String email, double amount);
}
