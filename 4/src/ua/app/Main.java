package ua.app;

import ua.util.*;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        GenericRepository<Patient> patientRepo =
                new GenericRepository<>(Patient::patientId);

        GenericRepository<Doctor> doctorRepo =
                new GenericRepository<>(d -> d.firstName() + d.lastName());

        Patient p1 = new Patient("Ivan", "Petrenko", "PE-1001", LocalDate.of(2000, 5, 10));
        Patient p2 = new Patient("Olga", "Ivanova", "PE-1002", LocalDate.of(1998, 3, 22));
        Patient p3 = new Patient("Ivan", "Petrenko", "PE-1001", LocalDate.of(2000, 5, 10));

        patientRepo.add(p1);
        patientRepo.add(p2);
        patientRepo.add(p3);

        Doctor d1 = new Doctor("Andrii", "Koval", Specialty.CARDIOLOGIST);
        Doctor d2 = new Doctor("Iryna", "Shevchenko", Specialty.DERMATOLOGIST);

        doctorRepo.add(d1);
        doctorRepo.add(d2);

        Optional<Patient> found = patientRepo.findByIdentity("PE-1001");

        System.out.println("=== FOUND PATIENT ===");
        found.ifPresent(System.out::println);

        System.out.println("\n=== ALL PATIENTS ===");
        patientRepo.getAll().forEach(System.out::println);

        System.out.println("\n=== DUPLICATES DEMO ===");
        System.out.println("Total patients stored: " + patientRepo.getAll().size());

        System.out.println("\n=== ALL DOCTORS ===");
        doctorRepo.getAll().forEach(System.out::println);
    }
}
