package ua.util;
public record Medication(String name, String dosage, MedicationType type) {
    public Medication {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid name");
        if (dosage == null || dosage.isBlank()) throw new IllegalArgumentException("Invalid dosage");
        if (type == null) throw new IllegalArgumentException("type null");
    }
}
