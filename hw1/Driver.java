/*
 * Frank Ziegler
 * HW 1
 * OOD; Professor Chu
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * This is a driver class that allows a user to manage their medical appointments. 
 * It uses an integer-style menu, where users type 1 to add a new appointment, and 2 to search for one by date.
 * And 0 to quit the application. 
 *
 * @author Frank Ziegler
 * @version 1.3
 */
public class Driver {
    
    static Scanner sc = new Scanner(System.in); // reads user input

    /**
     * Driver function to add a new appointment to your list of appointments. Prompts you for necessary appointment information like description and date.
     * Descriptions can be empty. Dates must follow MM-DD-YYYY format or else you will be prompted to re-enter. 
     * Choose 1 for onetime, 2 for monthly, and 3 for daily. Integers otherwise and non-integer input will reprompt you.
     *
     * @param appointments      list of user's current appointments
     */
    public static void addAppointment(ArrayList<Appointment> appointments) {
        System.out.print("Description: ");
        String description = sc.nextLine();
        System.out.println(description);
        System.out.print("Date (MM-DD-YYYY): ");
        LocalDate date = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-d-yyyy");
        while (date == null) {
            String dateString = sc.nextLine();
            System.out.println(dateString);
            if (dateString == null || dateString.isBlank()) {
                System.out.print("Date cannot be empty: ");
            } else {
                try {
                    date = LocalDate.parse(dateString, dtf);
                } catch (DateTimeParseException e) {
                    System.out.print("Format should be (MM-DD-YYYY): ");
                }
            }
        }
        LocalDateTime timestamp = LocalDateTime.now();
        System.out.print("Choose 1 for Onetime, 2 for Monthly, or 3 for Daily: ");
        int type = -1;
        while (type == -1) {
            try {
                type = sc.nextInt();
                System.out.println(type);
                if (type == 1) {
                    appointments.add(new Onetime(description, date, timestamp));
                } else if (type == 2) {
                    appointments.add(new Monthly(description, date, timestamp));
                } else if (type == 3) {
                    appointments.add(new Daily(description, date, timestamp));
                } else {
                    System.out.print("Must be an integer 1-3. Choose 1 for Onetime, 2 for Monthly, or 3 for Daily: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Must be an integer 1-3. Choose 1 for Onetime, 2 for Monthly, or 3 for Daily: ");
            }
        }
        sc.nextLine();
    }

    /**
     * Driver function to search for all appointments occurring on a given date. 
     * Prompts user for date in MM-DD-YYYY format. Then searches the current list of appointments for date matches using respective occursOn method.
     *
     * @param appointments      list of user's current appointments
     */
    public static void printAppointmentsOnDate(ArrayList<Appointment> appointments) {
        StringBuilder sb = new StringBuilder();
        System.out.print("Enter date to search (MM-DD-YYYY): ");
        LocalDate date = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-d-yyyy");
        while (date == null) {
            String dateString = sc.nextLine();
            System.out.println(dateString);
            if (dateString == null || dateString.isBlank()) {
                System.out.print("Date cannot be empty: ");
            } else {
                try {
                    date = LocalDate.parse(dateString, dtf);
                } catch (DateTimeParseException e) {
                    System.out.print("Format should be (MM-DD-YYYY): ");
                }
            }
        }
        sb.append("Your appointments on " + date.getMonthValue() + "-" + date.getDayOfMonth() + "-" + date.getYear() + ":");
        for (Appointment appointment : appointments) {
            if (appointment.occursOn(date.getYear(), date.getMonthValue(), date.getDayOfMonth())) {
                sb.append("\n" + appointment.toString());
            }
        }
        System.out.println(sb.toString());
    }

    /**
    * Entry point for the Appointment Manager program.
    *
    * Provides a simple terminal menu for the user to add new appointments or search for appointments by date.
    * Continues prompting the user to choose an option:
    * 1: Add a new appointment
    * 2: Search for appointments by date
    * 0: Quit
    *
    * @param args               command-line arguments
    */
    public static void main(String[] args) {
        boolean quit = false;
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        System.out.println("Welcome to HW 1.");
        System.out.println("Enter 1 to add a new appointment.");
        System.out.println("Enter 2 to search appointments by date.");
        while (!quit) {
            System.out.println();
            System.out.print("Enter an option or 0 to quit: ");
            int menu = -1;
            while (menu == -1) {
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    System.out.print("Menu choice cannot be empty. Enter 0, 1, or 2: ");
                    continue;
                }
                try {
                    int temp = Integer.parseInt(input);
                    if (temp > 2 || temp < 0) {
                        System.out.print("Menu choice must be 0, 1, or 2: ");
                    } else {
                        menu = temp;
                        System.out.println(menu);
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Menu choice must be an integer 0, 1, or 2: ");
                }
            }
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