/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*/
package service;

import model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner; 

public class InputCollector {

    public static final Scanner sc = new Scanner(System.in);

    public static RTransactionType collectTransactionType() {
        System.out.println("1. New registration");
        System.out.println("2. Renew registration");
        System.out.println("3. Transfer registration");
        System.out.print("Choose transaction type: ");
        int choice = sc.nextInt();
        RTransactionType tt = null;
        switch(choice) {
            case 1:
                tt = RTransactionType.INITIAL;
                break;
            case 2:
                tt = RTransactionType.RENEWAL;
                break;
            case 3:
                tt = RTransactionType.TRANSFER;
                break;
        }
        System.out.println(tt);
        return tt;
    }

    public static License collectLicense() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        System.out.print("Your name as it appears on your license: ");
        String name = sc.nextLine().trim();
        System.out.println(name);

        System.out.print("License number: ");
        String licenseNum = sc.nextLine().trim();
        System.out.println(licenseNum);

        System.out.print("License class (A-E): ");
        LicenseClass licenseClass = LicenseClass.valueOf(sc.nextLine().trim().toUpperCase());
        System.out.println(licenseClass);

        System.out.print("Date of birth (MM/DD/YYYY): ");
        String dobString = sc.nextLine().trim();
        LocalDate dob = LocalDate.parse(dobString, dateFormat);
        System.out.println(dob);

        System.out.print("Issued date (MM/DD/YYYY): ");
        String issDateString = sc.nextLine().trim();
        LocalDate issDate = LocalDate.parse(issDateString, dateFormat);
        System.out.println(issDate);

        System.out.print("Expiry date (MM/DD/YYYY): ");
        String expDateString = sc.nextLine().trim();
        LocalDate expDate = LocalDate.parse(expDateString, dateFormat);
        System.out.println(expDate);

        return new License(name, licenseNum, licenseClass, dob, issDate, expDate);
    }
    
    public static Customer collectCustomer() {
        System.out.println("1. Individual");
        System.out.println("2. Business");
        System.out.print("Choose customer type: ");
        int customerType = sc.nextInt(); sc.nextLine();
        System.out.println(customerType);

        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        System.out.println(name);

        System.out.print("Street address: ");
        String streetAddress = sc.nextLine().trim();
        System.out.println(streetAddress);

        System.out.print("City: ");
        String city = sc.nextLine().trim();
        System.out.println(city);

        System.out.print("Abbreviated state (NJ, PA, etc.): ");
        State state = State.valueOf(sc.nextLine().trim().toUpperCase());
        System.out.println(state);

        System.out.print("Zip: ");
        String zip = sc.nextLine().trim();
        System.out.println(zip);

        System.out.print("County: ");
        String county = sc.nextLine().trim();
        System.out.println(county);

        // assume address has not changed and there is no appointment

        Customer customer = null;
        switch(customerType) {
            case 1:
                License license = collectLicense();

                System.out.print("SSN: ");
                String ssn = sc.nextLine().trim();
                System.out.println(ssn);

                // assume customer has 6 points
                customer = new Individual(name, streetAddress, city, state, zip, county, false, false, license, ssn, true);
                break;
            case 2:
                System.out.print("EIN: ");
                String EIN = sc.nextLine().trim();
                customer = new Business(name, streetAddress, city, state, zip, county, false, false, EIN);
                break;
        }
        return customer;
    }

    public static Vehicle collectVehicle() {
        System.out.println("1. Car");
        System.out.println("2. Truck");
        System.out.println("3. Motorcycle");
        System.out.println("4. Boat");
        System.out.println("5. Commercial");
        System.out.print("Choose vehicle type: ");
        int vType = sc.nextInt(); sc.nextLine();
        System.out.println(vType); 

        System.out.print("Make: ");
        String make = sc.nextLine().trim();
        System.out.println(make);

        System.out.print("Model: ");
        String model = sc.nextLine().trim();
        System.out.println(model);

        System.out.print("Year: ");
        int year = sc.nextInt(); sc.nextLine();
        System.out.println(make);

        System.out.print("Color: ");
        String color = sc.nextLine().trim();
        System.out.println(color);
        
        System.out.print("Odometer reading: ");
        int odometer = sc.nextInt(); sc.nextLine();
        System.out.println(odometer);

        System.out.println("DIESEL, ETHANOL, ELECTRIC, GASOLINE, HYDROGEN, HYBRID, BIODIESEL, NATURAL_GAS, PREMIUM_UNLEADED");
        System.out.print("Choose fuel type: ");
        FuelType fuelType = FuelType.valueOf(sc.nextLine().trim().toUpperCase());
        System.out.println(fuelType);

        System.out.print("License plate number: ");
        String licensePlate = sc.nextLine().trim();
        System.out.println(licensePlate);

        System.out.print("GVWR: ");
        double gvwr = sc.nextDouble(); sc.nextLine();
        System.out.println(gvwr);

        Vehicle vehicle = null;
        String vin;
        int numWheels;
        switch (vType) {
            case 1: // car
                System.out.print("VIN: ");
                vin = sc.nextLine().trim();
                System.out.println(vin);

                vehicle = new Car(
                                make, 
                                model, 
                                year, 
                                color, 
                                odometer, 
                                fuelType, 
                                licensePlate, 
                                gvwr,
                                vin);
                break;
            case 2: // truck
                System.out.print("Number of wheels: ");
                numWheels = sc.nextInt(); sc.nextLine();
                System.out.println(numWheels);

                System.out.print("VIN: ");
                vin = sc.nextLine().trim();
                System.out.println(vin);

                vehicle = new Truck(
                                make, 
                                model, 
                                year, 
                                color, 
                                odometer, 
                                fuelType, 
                                licensePlate, 
                                gvwr,
                                numWheels,
                                vin);

                break;
            case 3: // motorcycle
                System.out.print("VIN: ");
                vin = sc.nextLine().trim();
                System.out.println(vin);

                vehicle = new Motorcycle(
                                make, 
                                model, 
                                year, 
                                color, 
                                odometer, 
                                fuelType, 
                                licensePlate, 
                                gvwr,
                                vin);

                break;
            case 4: // boat
                System.out.println("OPEN, CABIN, HOUSEBOAT, SAIL, AUXILLARY, CANOE, OTHER");
                System.out.print("Choose boat type: ");
                BoatType boatType = BoatType.valueOf(sc.nextLine().trim().toUpperCase());
                System.out.println(boatType);

                System.out.print("Boat length (inches): ");
                int boatLen = sc.nextInt(); sc.nextLine();
                System.out.println(boatLen);

                System.out.println("OUTBOARD, INBOARD, IO, ELECTRIC, OTHER, NONPOWERED");
                System.out.print("Propulsion type: ");
                Propulsion propulsion = Propulsion.valueOf(sc.nextLine().trim().toUpperCase());
                System.out.println(propulsion);

                System.out.print("HIN: ");
                String hin = sc.nextLine().trim();
                System.out.println(hin);

                vehicle = new Boat(
                                make, 
                                model, 
                                year, 
                                color, 
                                odometer, 
                                fuelType, 
                                licensePlate, 
                                gvwr,
                                boatType,
                                boatLen,
                                propulsion, 
                                hin);
                break;
            case 5: // commercial
                System.out.print("Number of wheels: ");
                numWheels = sc.nextInt(); sc.nextLine();
                System.out.println(numWheels);

                System.out.print("VIN: ");
                vin = sc.nextLine();
                System.out.println(vin);

                System.out.print("Seating capacity: ");
                int seatingCap = sc.nextInt(); sc.nextLine();
                System.out.println(seatingCap);

                System.out.println("11, 13, 14, 16-19, 21, 24, 31-33, 39, 41, 51, 52, 54, 56, 58, 59, 99");
                System.out.print("Commercial class code: ");
                int code = sc.nextInt(); sc.nextLine();
                
                vehicle = new Commercial(
                                make, 
                                model, 
                                year, 
                                color, 
                                odometer, 
                                fuelType, 
                                licensePlate, 
                                gvwr,
                                numWheels,
                                vin,
                                seatingCap,
                                code
                                );
                break;
        }
        return vehicle;
    }

    public static Registration collectRegistration(Customer customer, Vehicle vehicle) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        
        System.out.print("Registration ID: ");
        String rid = sc.nextLine().trim();
        System.out.println(rid);
        
        System.out.print("Issued date (MM/DD/YYYY): ");
        String issDateString = sc.nextLine().trim();
        LocalDate issDate = LocalDate.parse(issDateString, dateFormat);

        System.out.print("Expiry date (MM/DD/YYYY): ");
        String expDateString = sc.nextLine().trim();
        LocalDate expDate = LocalDate.parse(expDateString, dateFormat);

        Registration reg = new Registration(
                                        rid,
                                        customer,
                                        vehicle,
                                        issDate,
                                        expDate,
                                        vehicle.getLicensePlate()
        );
        return reg;
    }

    public static RTransaction collectTransaction() {
        
        RTransactionType transactionType = collectTransactionType();
        Customer existingOwner = collectCustomer();
        Customer nextOwner = null;
        Vehicle vehicle = collectVehicle();
        Registration registration = null;
        RTransaction rtx = null;

        switch(transactionType) {
            case INITIAL:
                System.out.println("Do you want custom plates?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Choice: ");
                int choice = sc.nextInt(); sc.nextLine();
                System.out.println(choice);
                String customPlate = null;
                switch (choice) {
                    case 1:
                        System.out.print("Enter your plate: ");
                        customPlate = sc.nextLine();
                        System.out.println(customPlate);
                        break;
                    case 2:
                        break;
                }
                rtx = new TransactionBuilder()
                                    .type(transactionType)
                                    .oldCustomer(existingOwner)
                                    .vehicle(vehicle)
                                    .withCustomPlate(customPlate)
                                    .build();
                break;
            case RENEWAL:
                registration = collectRegistration(existingOwner, vehicle);
                rtx =  new TransactionBuilder()
                                    .type(transactionType)
                                    .oldCustomer(existingOwner)
                                    .vehicle(vehicle)
                                    .registration(registration)
                                    .build();
                break;
            case TRANSFER:
                registration = collectRegistration(existingOwner, vehicle);
                System.out.println("Fill out the new owner's info:");
                nextOwner = collectCustomer();
                rtx = new TransactionBuilder()
                                    .type(transactionType)
                                    .oldCustomer(existingOwner)
                                    .nextCustomer(nextOwner)
                                    .registration(registration)
                                    .vehicle(vehicle)
                                    .build();
                break;
        }
        return rtx;
    }
}