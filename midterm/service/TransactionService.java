package service;
import repository.*;
import model.RTransaction;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * OOD midterm
 * @author frank w. ziegler III
 * @version 1.0.0
 */

public class TransactionService {

    private FeeCalculator rfc;
    private RTransactionRepo rtr;

    public TransactionService(RTransactionRepo rtr) {
        rfc = new FeeCalculator(new ArrayList<FeeRule>(Arrays.asList(new BasicAutomobileFeeRule(), new BoatFeeRule(), new MotorcycleFeeRule(), new ZEVFeeRule())));
        this.rtr = rtr;
    }

    public double process(RTransaction rtx) {
        TransactionProcessor tp = ProcessorFactory.getProcessor(rtx.getRTransactionType());
        tp.updateRecord(rtx);
        double fee = rfc.calculateFee(rtx);
        rtx.setFee(fee);
        return fee;   
    }

    public void finalize(RTransaction rtx) {
        rtr.save(rtx);
    }
}