/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package repository;

import model.RTransaction;
import java.io.*;

public class RTransactionRepo {

    private final String filePath = "/Users/frankzigs/Desktop/school/OOD/midterm/repository/RTransactionsDatabase.txt";

    private RTransactionRepo() {}

    private static class Holder {
        private static final RTransactionRepo instance = new RTransactionRepo();
    }

    public static final RTransactionRepo getInstance() {
        return Holder.instance;
    }

    public synchronized void save(RTransaction rtx) {
        try(FileWriter fw = new FileWriter(filePath, true);
            PrintWriter pw = new PrintWriter(fw)) {
            pw.println("tid: " + rtx.getTransactionId());
            pw.println("type: " + rtx.getRTransactionType());
            pw.println("customer: " + rtx.getCustomer().getName());
            pw.println("vehicle: " + rtx.getVehicle().getYear()  + " " + rtx.getVehicle().getMake() + " " + rtx.getVehicle().getModel());
            pw.println("Fee: $" + rtx.getFee());
            pw.println("----------------"); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}