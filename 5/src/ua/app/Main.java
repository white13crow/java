package ua.app;

import ua.util.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== LR5: Sorting & Comparator ===");

        PatientRepository patientRepo = new PatientRepository();
        DoctorRepository doctorRepo = new DoctorRepository();

        patientRepo.add(new Patient("Ivan", "Petrenko", "P3",
                LocalDate.of(2000, 5, 10)));
        patientRepo.add(new Patient("Olga", "Ivanova", "P1",
                LocalDate.of(1999, 3, 20)));
        patientRepo.add(new Patient("Andrii", "Shevchenko", "P2",
                LocalDate.of(2001, 7, 5)));

        System.out.println("\n--- Sorted by ID ASC ---");
        patientRepo.sortByIdentity("asc");
        patientRepo.getAll().forEach(System.out::println);

        System.out.println("\n--- Sorted by Last Name ---");
        patientRepo.sortByLastName();
        patientRepo.getAll().forEach(System.out::println);

        System.out.println("\n--- Sorted by Birth Date ---");
        patientRepo.sortByBirthDate();
        patientRepo.getAll().forEach(System.out::println);

        doctorRepo.add(new Doctor("Andrii", "Koval",
                Specialty.CARDIOLOGIST));
        doctorRepo.add(new Doctor("Iryna", "Shevchenko",
                Specialty.DERMATOLOGIST));
        doctorRepo.add(new Doctor("Petro", "Ivanov",
                Specialty.NEUROLOGIST));

        System.out.println("\n--- Doctors by Specialty ---");
        doctorRepo.sortBySpecialty();
        doctorRepo.getAll().forEach(System.out::println);

        System.out.println("\n--- Doctors by First Name ---");
        doctorRepo.sortByFirstName();
        doctorRepo.getAll().forEach(System.out::println);

        System.out.println("\n=== END LR5 ===");
    }
}
