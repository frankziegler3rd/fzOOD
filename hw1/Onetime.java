/*
 * Frank Ziegler
 * HW 1
 * OOD; Professor Chu
 */

import java.time.LocalDate;
import java.time.LocalDateTime;

class Onetime extends Appointment {

	public Onetime(String firstName, String lastName, String description, LocalDate date, LocalDateTime timestamp) {
		super(firstName, lastName, description, date, timestamp);
	}

	public boolean occursOn(int year, int month, int day) {
		return LocalDate.of(year, month, day).equals(super.getDate());
	}

	public String toString() {
        return "[ONETIME]: " + super.toString();
    }
}
