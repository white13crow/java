package ua.util;

import java.time.LocalDateTime;

public record MedicalRecord(
        Patient patient,
        String diagnosis,
        String treatment,
        LocalDateTime recordDateTime
) {
    public MedicalRecord {
        if (patient == null)
            throw new IllegalArgumentException("Patient required");
        if (diagnosis == null || diagnosis.isBlank())
            throw new IllegalArgumentException("Invalid diagnosis");
        if (treatment == null || treatment.isBlank())
            throw new IllegalArgumentException("Invalid treatment");
        if (recordDateTime == null)
            throw new IllegalArgumentException("Invalid record date");
    }
}
