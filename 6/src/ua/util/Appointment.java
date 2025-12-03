package ua.util;

import java.time.LocalDateTime;

public record Appointment(
        Patient patient,
        Doctor doctor,
        LocalDateTime dateTime,
        AppointmentStatus status
) {
    public Appointment {
        if (patient == null || doctor == null)
            throw new IllegalArgumentException("Patient and doctor required");
        if (dateTime == null)
            throw new IllegalArgumentException("Invalid date/time");
        if (status == null)
            throw new IllegalArgumentException("Invalid status");
    }
}
