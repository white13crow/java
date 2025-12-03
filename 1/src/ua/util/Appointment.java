package ua.util;

import java.time.LocalDateTime;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;

    public Appointment(Patient p, Doctor d, LocalDateTime dt) {
        if (p == null || d == null)
            throw new IllegalArgumentException("Patient or doctor is null");
        if (!ValidationHelper.isValidDateTime(dt))
            throw new IllegalArgumentException("Invalid date/time");

        this.patient = p;
        this.doctor = d;
        this.appointmentDateTime = dt;
    }

    public static Appointment schedule(Patient p, Doctor d, LocalDateTime dt) {
        return new Appointment(p, d, dt);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", dateTime=" + Utils.formatDateTime(appointmentDateTime) +
                '}';
    }
}
