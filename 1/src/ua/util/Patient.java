package ua.util;

import java.time.LocalDate;

public class Patient extends Person {
    private String patientId;
    private LocalDate birthDate;

    public Patient(String fn, String ln, String id, LocalDate bd) {
        super(fn, ln);
        if (!ValidationHelper.isValidId(id))
            throw new IllegalArgumentException("Invalid ID");
        if (!ValidationHelper.isValidDate(bd))
            throw new IllegalArgumentException("Invalid birth date");

        this.patientId = id;
        this.birthDate = bd;
    }

    // factory
    public static Patient create(String fn, String ln, LocalDate bd) {
        String id = Utils.generatePatientId(ln);
        return new Patient(fn, ln, id, bd);
    }

    public String getPatientId() { return patientId; }
    public LocalDate getBirthDate() { return birthDate; }

    @Override
    public String toString() {
        return "Patient{" + super.toString()
                + ", id='" + patientId + '\''
                + ", birthDate=" + birthDate + '}';
    }
}
