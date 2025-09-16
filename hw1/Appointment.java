/*
 * Frank Ziegler
 * HW 1
 * OOD; Professor Chu
 */

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Appointment {

	private String firstName;
	private String lastName;
	private String description;
	private LocalDate date;
	private LocalDateTime timestamp;
	
	public Appointment(String description, LocalDate date, LocalDateTime timestamp) {
		this.description = description;
		this.date = date;
		this.timestamp = timestamp;
	}	

	public abstract boolean occursOn(int year, int month, int day);
	
	public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

	public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public LocalDateTime getDateAppointmentWasMade() { return timestamp; }

    public void setDateAppointmentWasMade(LocalDateTime timestamp) { this.timestamp = timestamp; }

	public String toString() {
		return description + 
			   " (" + date.getMonthValue() + "-" + date.getDayOfMonth() + "-" + date.getYear() + ") | " +
			   "created " + timestamp;
	}
}
