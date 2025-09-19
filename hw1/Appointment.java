/*
 * Frank Ziegler
 * HW 1
 * OOD; Professor Chu
 */

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * This class models a generic appointment. 
 * It is declared abstract because:
 * 1. It provides common functionality for three related subclasses.
 * 2. Appointments are too generic for instantiation.
 * 3. It supports polymorphism, thus making this application more reusable. 
 * 
 * @author Frank Ziegler
 * @version 1.3
 */
public abstract class Appointment {

	private String description; 
	private LocalDate date;
	private LocalDateTime timestamp; // the date and time the appointment was created
	
	/**
	 * Constructs a new appointment.
	 *
	 * @param description	description of the appointment
	 * @param date			date of the appointment
	 * @param timestamp		date and time the appointment was made
	 */
	public Appointment(String description, LocalDate date, LocalDateTime timestamp) {
		this.description = description;
		this.date = date;
		this.timestamp = timestamp;
	}	

	/**
	 * Checks if an appointment with year-month-day date exists.
	 * It is declared abstract because:
	 * 1. Subclasses have different use cases for this method. 
	 * ---- i.e. Daily appointments are forever recurring after the appointment was made.
	 * ---- Thus this method would need to return true for any date searched after it was made. 
	 *
	 * @param year			year of the appointment searched
	 * @param month			month of the appointment searched
	 * @param day			day of the appointment searched
	 */ 
	public abstract boolean occursOn(int year, int month, int day);
	
	/**
	 * Gets the description of the appointment.
	 *
	 * @return				description of the appointment
	 */
	public String getDescription() { return description; }

	/**
	 * Sets the description of the appointment.
	 *
	 * @param description	description of the appointment
	 */
    public void setDescription(String description) { this.description = description; }

	/**
	 * Gets the date of the appointment.
	 *
	 * @return				date of the appointment
	 */
	public LocalDate getDate() { return date; }

	/**
	 * Sets the date of the appointment.
	 *
	 * @param date			date of the appointment
	 */
    public void setDate(LocalDate date) { this.date = date; }

	/**
	 * Gets the date and time the appointment was made.
	 *
	 * @return				date and time the appointment was made
	 */
    public LocalDateTime getDateAppointmentWasMade() { return timestamp; }

	/**
	 * Sets the date and time the appointment was made.
	 *
	 * @param timestamp		date and time the appointment was made
	 */
    public void setDateAppointmentWasMade(LocalDateTime timestamp) { this.timestamp = timestamp; }

	/**
	 * Overrides the generic Object toString function and prints appointment details.
	 *
	 * @return				string representation of the appointment
	 */
	public String toString() {
		return description + 
			   " (" + date.getMonthValue() + "-" + date.getDayOfMonth() + "-" + date.getYear() + ") | " +
			   "created " + timestamp;
	}
}
