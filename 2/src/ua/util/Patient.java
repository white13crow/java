package ua.util;

import java.time.LocalDate;

public record Patient(
        String firstName,
        String lastName,
        String patientId,
        LocalDate birthDate
) {
    public Patient {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("Invalid first name");
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("Invalid last name");
        if (patientId == null || patientId.isBlank())
            throw new IllegalArgumentException("Invalid patient ID");
        if (birthDate == null)
            throw new IllegalArgumentException("Invalid birth date");
    }
}
