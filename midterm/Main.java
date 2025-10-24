import java.io.*;
import java.util.Scanner;
import model.*;
import service.*;
import repository.*;

/**
 * Transaction builder?
 * Car and truck are basically being treated the same. make them a PassengerAutomobile?
 */
public class Main {
    
    private static final Scanner sc = new Scanner(System.in);

    public static void newTransaction() {
        RTransaction rtx = InputCollector.collectTransaction();
        RTransactionRepo rtr = RTransactionRepo.getInstance();
        TransactionService ts = new TransactionService(rtr);
        double fee = ts.process(rtx); // retrieve the updated RTX here with the updated registration
        System.out.println("Your fee is $" + fee + ". To pay, type and enter that number or more.");
        System.out.print("Pay here: ");
        double payment = sc.nextDouble(); sc.nextLine();
        
        if(payment - fee > 0) {
            System.out.println("Your change is $" + (payment - fee));
        } else if (payment - fee == 0) {
            System.out.println("Exact change. I like it.");
        } else {
            System.out.println("Not enough. I still saved your transaction to the database, but once I extend this, you're in trouble.");
        }
        System.out.println("Here is your new registration:");
        System.out.println(rtx.getRegistration().toString());
        ts.finalize(rtx);
    }

    public static void main(String[] args) {
        System.out.println("+--------------------------------+");
        System.out.println("|                                |");
        System.out.println("|      welcome to the njmvc      |");
        System.out.println("|   online registration system   |");
        System.out.println("|          ood midterm           |");
        System.out.println("|         frank ziegler          |");
        System.out.println("|                                |");
        System.out.println("+--------------------------------+");
    
        boolean quit = false;

        while(!quit) {
            
            System.out.println("\nMain Menu");
            System.out.println("1. New transaction");
            System.out.println("0. Quit");
            int menu = sc.nextInt();
            switch(menu) {
                case 1:
                    newTransaction();
                    break;
                case 0:
                    quit = true;
                    System.out.println("Goodbye.");
                    break;
            }
            
        }
    }
}