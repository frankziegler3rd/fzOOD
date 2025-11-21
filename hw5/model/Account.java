/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package model;

public class Account {

    private String username;
    private String routingNumber;
    private String accountNumber;
    private double balance;
    private boolean useForZelle;

    public Account(String username, String routingNumber, String accountNumber, double balance) {
        this.username = username;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.balance = balance;
        useForZelle = false;
    }

    public String   getUsername() { return username; }
    public void     setUsername(String username) { this.username = username; }
    public String   getRoutingNumber() { return routingNumber; }
    public void     setRoutingNumber(String routingNumber) { this.routingNumber = routingNumber; }
    public String   getAccountNumber() { return accountNumber; }
    public void     setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public double   getBalance() { return balance; }
    public void     setBalance(double balance) { this.balance = balance; }
    public boolean  getUseForZelle() { return useForZelle; }
    public void     setUseForZelle(boolean useForZelle) { this.useForZelle = useForZelle; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        return username + " | routing: " + routingNumber + " | account number: " + accountNumber + " | balance: " + balance;
    }
}
