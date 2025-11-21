/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import model.Account;
import java.lang.reflect.Type;
import java.io.IOException;

public class AccountRepo {

    private Gson gson;
    private List<Account> accounts;
    private String filePath;

    private AccountRepo(String filePath) {
        this.gson = new Gson();
        this.accounts = new ArrayList<>();
        this.filePath = filePath;
        loadAccounts();
    }

    public static class Holder {
        static final AccountRepo INSTANCE = new AccountRepo("/Users/frankzigs/dev/OOD/hw5/repo/AccountDB.json");
    }

    public static final AccountRepo getInstance() {
        return Holder.INSTANCE;
    }

    public void loadAccounts() {
        try(FileReader fr = new FileReader(filePath)) {
            Type listType = new TypeToken<List<Account>>() {}.getType();
            accounts = gson.fromJson(fr, listType);
        } catch (IOException e) {
            accounts = new ArrayList<>();
        }
    }

    public Account findByAccountNumber(String accountNumber) {
        for(Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public List<Account> findByUsername(String username) {
        List<Account> userAccounts = new ArrayList<>();
        for(Account account : accounts) {
            if(account.getUsername().equals(username)) {
                userAccounts.add(account);
            }
        }
        return userAccounts;
    }

    public boolean addAccount(Account account) {
        try(FileWriter fw = new FileWriter(filePath)) {
            accounts.add(account);
            gson.toJson(accounts, fw);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean deleteAccount(Account account) {
        try(FileWriter fw = new FileWriter(filePath)) {
            accounts.remove(account);
            gson.toJson(accounts, fw);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean updateAccountBalance(Account account, double toAdd) {
        try(FileWriter fw = new FileWriter(filePath)) {
            account.setBalance(account.getBalance() + toAdd);
            gson.toJson(accounts, fw);
            return true;
        } catch(IOException e) {
            return false;
        }
    }
}
