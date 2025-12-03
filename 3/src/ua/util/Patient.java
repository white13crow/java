package ua.util;
import java.time.LocalDate;
public record Patient(String firstName, String lastName, String patientId, LocalDate birthDate) {
    public Patient {
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("Invalid firstName");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Invalid lastName");
        if (patientId == null || patientId.isBlank()) throw new IllegalArgumentException("Invalid patientId");
        if (birthDate == null) throw new IllegalArgumentException("Invalid birthDate");
    }
}
