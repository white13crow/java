package ua.util;

import java.time.LocalDateTime;

public class MedicalRecord {
    private Patient patient;
    private String diagnosis;
    private String treatments;
    private LocalDateTime recordDateTime;

    public MedicalRecord(Patient p, String d, String t, LocalDateTime dt) {
        if (p == null)
            throw new IllegalArgumentException("Patient null");
        if (!ValidationHelper.isValidText(d))
            throw new IllegalArgumentException("Invalid diagnosis");
        if (!ValidationHelper.isValidText(t))
            throw new IllegalArgumentException("Invalid treatment");

        this.patient = p;
        this.diagnosis = d;
        this.treatments = t;
        this.recordDateTime = dt;
    }

    public static MedicalRecord create(Patient p, String d, String t) {
        return new MedicalRecord(p, d, t, LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "patient=" + patient +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatments='" + treatments + '\'' +
                ", dateTime=" + recordDateTime +
                '}';
    }
}
