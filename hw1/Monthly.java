/*
 * Frank Ziegler
 * HW 1
 * OOD; Professor Chu
 */

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * This class represents a Monthly version of the abstract Appointment class.
 * It inherits all top level attributes and does not need any additional ones. 
 *
 * @author Frank Ziegler
 * @version 1.3
 */
public class Monthly extends Appointment {

    /**
     * Creates a new monthly appointment by calling the parent constructor.
     *
     * @param description	description of the appointment
	 * @param date			date of the appointment
	 * @param timestamp		date and time the appointment was made
     */
    public Monthly(String description, LocalDate date, LocalDateTime timestamp) {
		super(description, date, timestamp);
	}

    /**
     * This is the Monthly implementation of the parent occursOn method.
     * Returns true if the date is the date of the appoint or, if it is after and on the same day of the month as the day it was made. 
     * i.e. If the appointment was 9-10-2012:
     * ---- It returns false for 8-10-2012, 10-11-2012
     * ---- Returns true for 9-10-2012, 10-10-2012
     *
     * @param year			year of the appointment searched
	 * @param month			month of the appointment searched
	 * @param day			day of the appointment searched
     */
    public boolean occursOn(int year, int month, int day) {
        LocalDate sDate = LocalDate.of(year, month, day); // searched date
        LocalDate aDate = super.getDate(); // appointment date
        return sDate.equals(aDate) || (sDate.isAfter(aDate) && day == sDate.getDayOfMonth());
    }

    /**
     * Overrides the Appointment parent toString by appending [MONTHLY] to it, so that users will know it is a monthly appointment.
     * Calls the parent toString for the rest of the work. 
     *
     * @return              string representation of the appointment
     */
    public String toString() {
        return "[MONTHLY]: " + super.toString();
    }
 }