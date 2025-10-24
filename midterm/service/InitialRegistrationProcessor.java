package service;
import java.util.UUID;
import java.time.LocalDate;
import model.RTransaction;
import model.Registration;

public class InitialRegistrationProcessor implements TransactionProcessor {
    
    public void updateRecord(RTransaction rtx) {
        String plate = rtx.getCustomPlate() == null ? LicensePlateService.generate() : rtx.getCustomPlate();
        rtx.getVehicle().setLicensePlate(plate);
        Registration newRegistration = new Registration(
            UUID.randomUUID().toString(),
            rtx.getCustomer(),
            rtx.getVehicle(),
            LocalDate.now(),
            LocalDate.now().plusYears(1),
            rtx.getVehicle().getLicensePlate()
        );
        rtx.setRegistration(newRegistration);
    }
}