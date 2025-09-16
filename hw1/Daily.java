/*
 * Frank Ziegler
 * HW 1
 * OOD; Professor Chu
 */

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Daily extends Appointment {

    public Daily(String description, LocalDate date, LocalDateTime timestamp) {
		super(description, date, timestamp);
	}

    public boolean occursOn(int year, int month, int day) {
        LocalDate ld = LocalDate.of(year, month, day);
        return ld.equals(super.getDate()) || ld.isAfter(super.getDate());
    }

    public String toString() {
        return "[DAILY]: " + super.toString();
    }
 }