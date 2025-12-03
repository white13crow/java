package ua.app;

import ua.util.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== SUCCESS CASES ===");

        Patient p = Patient.create("Ivan", "Petrenko",
                LocalDate.of(2000,5,10));

        Doctor d = Doctor.of("Olga", "Shevchenko", "Therapist");

        Appointment a = Appointment.schedule(
                p, d, LocalDateTime.now());

        Medication m = Medication.of(
                "Paracetamol", "500mg", "2 times per day");

        MedicalRecord r = MedicalRecord.create(
                p, "Flu", "Rest and medication");

        System.out.println(p);
        System.out.println(d);
        System.out.println(a);
        System.out.println(m);
        System.out.println(r);

        System.out.println("\n=== ERROR CASE ===");

        try {
            Patient bad = Patient.create("", "Test", LocalDate.now());
        } catch (Exception e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
