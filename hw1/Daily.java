/*
 * Frank Ziegler
 * HW 1
 * OOD; Professor Chu
 */

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * This class represents a Daily version of the abstract Appointment class.
 * It inherits all top level attributes and does not need any additional ones. 
 *
 * @author Frank Ziegler
 * @version 1.2
 */
public class Daily extends Appointment {

    /*
     * Creates a new daily appointment by calling the parent constructor.
     *
     * @param description	description of the appointment
	 * @param date			date of the appointment
	 * @param timestamp		date and time the appointment was made
     */
    public Daily(String description, LocalDate date, LocalDateTime timestamp) {
		super(description, date, timestamp);
	}

    /*
     * This is the Daily implementation of the parent occursOn method.
     * Returns true if the date is the date of the appointment or is after the date of the appointment.
     *
     * @param year			year of the appointment searched
	 * @param month			month of the appointment searched
	 * @param day			day of the appointment searched
     */
    public boolean occursOn(int year, int month, int day) {
        LocalDate ld = LocalDate.of(year, month, day);
        return ld.equals(super.getDate()) || ld.isAfter(super.getDate());
    }

    /*
     * Overrides the Appointment parent toString by appending [DAILY] to it, so that users will know it is a daily appointment.
     * Calls the parent toString for the rest of the work. 
     *
     * @return              string representation of the appointment
     */
    public String toString() {
        return "[DAILY]: " + super.toString();
    }
 }