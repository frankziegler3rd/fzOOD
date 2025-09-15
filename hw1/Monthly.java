/*
 * Frank Ziegler
 * HW 1
 * OOD; Professor Chu
 */

import java.time.LocalDate;
import java.time.LocalDateTime;

 public class Monthly extends Appointment {

    public Monthly(String firstName, String lastName, String description, LocalDate date, LocalDateTime timestamp) {
		super(firstName, lastName, description, date, timestamp);
	}

    public boolean occursOn(int year, int month, int day) {
        return day == super.getDate().getDayOfMonth();
    }

    public String toString() {
        return "[MONTHLY]: " + super.toString();
    }
 }