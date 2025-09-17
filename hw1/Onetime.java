/*
 * Frank Ziegler
 * HW 1
 * OOD; Professor Chu
 */

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * This class represents a Onetime version of the abstract Appointment class.
 * It inherits all top level attributes and does not need any additional ones. 
 *
 * @author Frank Ziegler
 * @version 1.3
 */
class Onetime extends Appointment {

	/*
     * Creates a new onetime appointment by calling the parent constructor.
     *
     * @param description	description of the appointment
	 * @param date			date of the appointment
	 * @param timestamp		date and time the appointment was made
     */
	public Onetime(String description, LocalDate date, LocalDateTime timestamp) {
		super(description, date, timestamp);
	}

    /*
     * This is the Onetime implementation of the parent occursOn method.
     * Returns true if the date is the exact date of the appointment.
     *
     * @param year			year of the appointment searched
	 * @param month			month of the appointment searched
	 * @param day			day of the appointment searched
     */
	public boolean occursOn(int year, int month, int day) {
		return LocalDate.of(year, month, day).equals(super.getDate());
	}

    /*
     * Overrides the Appointment parent toString by appending [ONETIME] to it, so that users will know it is a monthly appointment.
     * Calls the parent toString for the rest of the work. 
     *
     * @return              string representation of the appointment
     */
	public String toString() {
        return "[ONETIME]: " + super.toString();
    }
}
