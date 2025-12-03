package ua.util;

import java.util.Comparator;

public record Medication(
        String name,
        String dosage,
        MedicationType type
) implements Comparable<Medication> {

    @Override
    public int compareTo(Medication o) {
        return this.name.compareTo(o.name);
    }

    public static final Comparator<Medication> BY_TYPE =
            Comparator.comparing(Medication::type);
}
