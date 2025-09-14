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
	
	public Appointment(String firstName, String lastName, String description, LocalDate date, LocalDateTime timestamp) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.date = date;
		this.timestamp = timestamp;
	}	

	public abstract boolean occursOn(int year, int month, int day);

	public String getFirstName() { return firstName; }

	public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
	
	public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

	public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public LocalDateTime getDateAppointmentWasMade() { return timestamp; }

    public void setDateAppointmentWasMade(LocalDateTime timestamp) { this.timestamp = timestamp; }

	public String toString() {
		return "Name: " + lastName + ", " + firstName + 
			   "\nDate: " + date.getMonthValue() + "-" + date.getDayOfMonth() + "-" + date.getYear() +
			   "\nDescription: " + description +
			   "\nMade on: " + timestamp;
	}
}
