/*
 * Frank Ziegler
 * HW 1
 * OOD; Professor Chu
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Driver {
    
    static Scanner sc = new Scanner(System.in);

    // TODO: INPUT SANITIZATION
    public static void addAppointment(ArrayList<Appointment> appointments) {
        System.out.print("First name: ");
        String firstName = sc.next(); sc.nextLine();
        System.out.println(firstName);
        System.out.print("Last name: ");
        String lastName = sc.next(); sc.nextLine();
        System.out.println(lastName);
        System.out.print("Description: ");
        String description = sc.nextLine();
        System.out.println(description);
        System.out.print("Date (MM-DD-YYYY): ");
        String dateString = sc.next(); sc.nextLine();
        System.out.println(dateString);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate date = LocalDate.parse(dateString, dtf);
        LocalDateTime timestamp = LocalDateTime.now();
        System.out.print("Choose 1 for Onetime, 2 for Monthly, or 3 for Daily: ");
        int type = sc.nextInt(); sc.nextLine();
        System.out.println(type);
        if (type == 1) {
            appointments.add(new Onetime(firstName, lastName, description, date, timestamp));
        } else if (type == 2) {
            appointments.add(new Monthly(firstName, lastName, description, date, timestamp));
        } else {
            appointments.add(new Daily(firstName, lastName, description, date, timestamp));
        }
    }

    public static void printAppointmentsOnDate(ArrayList<Appointment> appointments) {
        StringBuilder sb = new StringBuilder();
        System.out.print("Enter date to search (MM-DD-YYYY): ");
        String dateString = sc.next(); sc.nextLine();
        System.out.println(dateString);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate date = LocalDate.parse(dateString, dtf);
        sb.append("All appointments on " + date.getMonthValue() + "-" + date.getDayOfMonth() + "-" + date.getYear() + ":");
        for (Appointment appointment : appointments) {
            if (appointment.occursOn(date.getYear(), date.getMonthValue(), date.getDayOfMonth())) {
                sb.append("\n" + appointment.toString());
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        boolean quit = false;
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        System.out.println("Welcome to HW 1.");
        System.out.println("Enter 1 to add a new appointment.");
        System.out.println("Enter 2 to search appointments by date.");
        while (!quit) {
            System.out.println();
            System.out.print("Enter an option or 0 to quit: ");
            int menu = sc.nextInt(); 
            if (sc.hasNextLine()) { 
                sc.nextLine(); 
            }
            System.out.println(menu);
            System.out.println();
            switch (menu) {
                case 0: 
                    quit = true;
                    System.out.println("Goodbye.");
                    break;
                case 1:
                    addAppointment(appointments);
                    break;
                case 2:
                    printAppointmentsOnDate(appointments);
                    break;
            }
        }
        sc.close();
    }
}