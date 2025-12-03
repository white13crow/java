package ua.app;

import ua.util.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== CREATING RECORD + ENUM OBJECTS ===");

        Patient p1 = new Patient(
                "Ivan", "Petrenko", "P-101",
                LocalDate.of(2000, 5, 10)
        );

        Doctor d1 = new Doctor(
                "Olga", "Shevchenko",
                Specialty.CARDIOLOGIST
        );

        Medication m1 = new Medication(
                "Paracetamol", "500mg",
                MedicationType.TABLET
        );

        Appointment a1 = new Appointment(
                p1, d1,
                LocalDateTime.now(),
                AppointmentStatus.SCHEDULED
        );

        MedicalRecord r1 = new MedicalRecord(
                p1, "Flu",
                "Rest and medication",
                LocalDateTime.now()
        );

        System.out.println(p1);
        System.out.println(d1);
        System.out.println(m1);
        System.out.println(a1);
        System.out.println(r1);

        System.out.println("\n=== SWITCH EXPRESSION DEMO ===");
        double price = MedicalSwitchUtil.getVisitPrice(d1.specialty());
        System.out.println("Visit price for " + d1.specialty() + ": " + price + " UAH");

        System.out.println("\n=== CLASSIC SWITCH-CASE DEMO ===");
        System.out.println(
                MedicalSwitchUtil.getStatusMessage(a1.status())
        );

        System.out.println("\n=== WORK WITH STRUCTURED DATA (LISTS) ===");

        List<Appointment> appointments = new ArrayList<>();
        appointments.add(a1);
        appointments.add(new Appointment(
                p1,
                new Doctor("Andrii", "Koval", Specialty.DERMATOLOGIST),
                LocalDateTime.now().plusDays(1),
                AppointmentStatus.COMPLETED
        ));
        appointments.add(new Appointment(
                p1,
                new Doctor("Iryna", "Bondar", Specialty.NEUROLOGIST),
                LocalDateTime.now().plusDays(2),
                AppointmentStatus.CANCELED
        ));

        for (Appointment a : appointments) {
            System.out.println(a + " -> "
                    + MedicalSwitchUtil.getStatusMessage(a.status()));
        }
    }
}
