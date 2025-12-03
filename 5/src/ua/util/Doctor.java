package ua.util;

import java.util.Comparator;

public record Doctor(
        String firstName,
        String lastName,
        Specialty specialty
) implements Comparable<Doctor> {

    @Override
    public int compareTo(Doctor o) {
        return this.lastName.compareTo(o.lastName);
    }

    public static final Comparator<Doctor> BY_SPECIALTY =
            Comparator.comparing(Doctor::specialty);

    public static final Comparator<Doctor> BY_FIRSTNAME =
            Comparator.comparing(Doctor::firstName);
}
