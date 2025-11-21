 /**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

import service.ServiceProxy;
import service.IUserOps;
import service.IAccountOps;
import model.*;
import java.util.Scanner;
import java.util.List;

/**
 * issue with this class is that the account ops don't grab the whole account and just the account number
 * may be worth it to refactor code to have the account object in hand
 */
public class Client {

    static final Scanner sc = new Scanner(System.in);
    static IUserOps uops = new ServiceProxy();
    static IAccountOps aops = (IAccountOps) uops;
    static String routingNumber = "d7d6bbd8-df65-4881-9006-03c7a8647747"; // my credit union routing number
    static String currUserUsername;

    /**
     * utilities
     * because i don't feel like typing out System.out.print/println("...") every time i want to print.
     */
    private static void p(Object o) { System.out.print(o); }
    private static void pl(Object o) { System.out.println(o); }

    public static void openAnAccount() {
        pl("1. checking");
        pl("2. saving");
        p("choose account type: ");
        int accountType = sc.nextInt(); sc.nextLine();
        pl(accountType);
        p("enter the amount you'd like to initially deposit: ");
        double initBalance = sc.nextDouble(); sc.nextLine();
        pl(initBalance);

        boolean worked = false;

        Account account = null;
        switch(accountType) {
            case 1:
                account = new Checking(currUserUsername, routingNumber, null, initBalance);
                break;
            case 2:
                account = new Saving(currUserUsername, routingNumber, null, initBalance);
                break;
            default:
                pl("not a valid option");
        }

        List<Account> userAccounts = aops.getUserAccountsByUsername(currUserUsername);
        if(userAccounts.size() == 0) {
            account.setUseForZelle(true);
            pl("this account by default is set for zelle. all zelle transactions will occur within this account."); 
        }

        if(aops.createAccount(account)) {
            pl("account successfully added");
        } else {
            pl("error creating account");
        }

    }

    public static void deleteAnAccount() {
        List<Account> userAccounts = aops.getUserAccountsByUsername(currUserUsername);
        int lim = userAccounts.size();
        if(lim == 0) {
            pl("no accounts to delete!");
        } else {
            for(int i = 0; i < lim; i++) {
                pl(i + ". " + userAccounts.get(i));
            }
            p("choose the account you'd like to delete: ");
            int choice = sc.nextInt(); sc.nextLine();
            pl(choice);
            String accountNumToDelete = userAccounts.get(choice).getAccountNumber();
            
            if(aops.deleteAccount(accountNumToDelete)) {
                pl("account successfully deleted");
            } else {
                pl("failed to delete account");
            }
        }
    }

    public static void withdrawFromAnAccount() {        
        List<Account> userAccounts = aops.getUserAccountsByUsername(currUserUsername);
        int lim = userAccounts.size();
        if(lim == 0) {
            pl("no accounts to withdraw from!");
        } else {
            for(int i = 0; i < lim; i++) {
                pl(i + ". " + userAccounts.get(i));
            }
            p("choose the account you'd like to withdraw from: ");
            int choice = sc.nextInt(); sc.nextLine();
            pl(choice);
            String accountNumToWithdraw = userAccounts.get(choice).getAccountNumber();
            p("withdrawal amount: "); 
            double withdrawalAmount = sc.nextDouble(); sc.nextLine();
            pl(withdrawalAmount);

            if(aops.withdraw(accountNumToWithdraw, withdrawalAmount)) {
                pl(withdrawalAmount + " successfully withdrawn from account");
            } else {
                pl("failed to withdraw from account");
            }
        }
    }

    public static void depositToAnAccount() {  
        List<Account> userAccounts = aops.getUserAccountsByUsername(currUserUsername);
        int lim = userAccounts.size();
        if(lim == 0) {
            pl("no accounts to deposit to!");
        } else {
            for(int i = 0; i < lim; i++) {
                pl(i + ". " + userAccounts.get(i));
            }
            p("choose the account you'd like to deposit to: ");
            int choice = sc.nextInt(); sc.nextLine();
            pl(choice);
            String accountNumToDeposit = userAccounts.get(choice).getAccountNumber();
            p("deposit amount: "); 
            double depositAmount = sc.nextDouble(); sc.nextLine();
            pl(depositAmount);

            if(aops.deposit(accountNumToDeposit, depositAmount)) {
                pl(depositAmount + " successfully deposited to account");
            } else {
                pl("failed to deposit to account");
            }
        }
    }

    public static void printAccounts() {
        List<Account> userAccounts = aops.getUserAccountsByUsername(currUserUsername);
        if(userAccounts.size() == 0) {
            pl("you don't have any accounts!");
        } else {
            for(Account account : userAccounts) {
                pl(account);
            }
        }
    }

    public static void zelleSend() {
        pl("1. phone number");
        pl("2. email");
        p("choose to zelle via email or phone number: ");
        int choice = sc.nextInt(); sc.nextLine();
        pl(choice);
        String phoneNumber = null, email = null;
        switch(choice) {
            case 1:
                p("enter a phone number: ");
                phoneNumber = sc.nextLine();
                pl(phoneNumber);
                break;
            case 2:
                p("enter an email: ");
                email = sc.nextLine();
                pl(email);
                break;
            default:
                pl("invalid option");
        }
        p("how much would you like to send: ");
        double amount = sc.nextDouble(); sc.nextLine();
        
        if(aops.zelleSend(currUserUsername, phoneNumber, email, amount)) {
            pl("zelle successful");
        } else {
            pl("zelle failed");
        }
    }

    public static boolean login() {
        p("username: ");
        String username = sc.nextLine().trim();
        pl(username);
        p("password: ");
        String password = sc.nextLine().trim();
        pl(password);
        if(uops.login(username, password)) {
            currUserUsername = username;
            return true;
        }
        return false;
    }

    public static void register() {
        p("full name: ");
        String name = sc.nextLine().trim();
        pl(name);
        p("username: ");
        String username = sc.nextLine().trim();
        pl(username);
        p("phone number: ");
        String phoneNumber = sc.nextLine().trim();
        pl(phoneNumber);
        p("email: ");
        String email = sc.nextLine().trim();
        pl(email);
        p("password: ");
        String password = sc.nextLine().trim();
        pl(password);
        User newUser = new User(name, username, phoneNumber, email, password);
        if(uops.register(newUser)) {
            pl("welcome to the ood hw5 credit union!");
        } else {
            pl("an error occurred signing you up. sorry!");
        }
    }

    public static void main(String[] args) {
        boolean auth = false;    
        boolean quit = false;
        IUserOps uops = new ServiceProxy();
        IAccountOps aops = (IAccountOps) uops;
        pl("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        pl("$$                                   $$");
        pl("$$                                   $$");
        pl("$$        ood hw5 credit union       $$");
        pl("$$                                   $$");
        pl("$$                                   $$");
        pl("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        pl("");
        
        while(!quit) {
            if(auth) {
                pl("1. open an account");
                pl("2. delete an existing account");
                pl("3. withdraw");
                pl("4. deposit");
                pl("5. send via zelle");
                pl("6. list my accounts");
                pl("7. logout");
                pl("0. quit");
                p("choose an option: "); 
                int authMenu = sc.nextInt(); sc.nextLine();
                pl(authMenu);

                switch(authMenu) {
                    case 1:
                        openAnAccount();
                        break;
                    case 2:
                        deleteAnAccount();
                        break;
                    case 3:
                        withdrawFromAnAccount();
                        break;
                    case 4:
                        depositToAnAccount();
                        break;
                    case 5: 
                        zelleSend();
                        break;
                    case 6:
                        printAccounts();
                        break;
                    case 7:
                        auth = false;
                        break;
                    case 0:
                        quit = true;
                        pl("goodbye.");
                        break;
                    default:
                        pl("not a valid menu option");
                }
            } else {
                pl("1. sign in");
                pl("2. register");
                pl("0. quit");
                
                p("choose an option: "); 
                int menu = sc.nextInt(); sc.nextLine();
                pl(menu);

                switch(menu) { 
                    case 1:
                        auth = login();
                        break;
                    case 2:
                        register();
                        break;
                    case 0:
                        quit = true;
                        pl("goodbye");
                        break;
                    default:
                        pl("not a valid menu option");
                }
            }
        }
    }
}

