package ua.util;

import java.time.LocalDate;
import java.util.Comparator;

public record Patient(
        String firstName,
        String lastName,
        String patientId,
        LocalDate birthDate
) implements Comparable<Patient> {

    @Override
    public int compareTo(Patient o) {
        return this.patientId.compareTo(o.patientId);
    }

    public static final Comparator<Patient> BY_LASTNAME =
            Comparator.comparing(Patient::lastName);

    public static final Comparator<Patient> BY_BIRTHDATE =
            Comparator.comparing(Patient::birthDate);
}
