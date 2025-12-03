package ua.app;

import ua.util.Patient;
import ua.util.Doctor;
import ua.util.Specialty;
import ua.util.PatientRepository;
import ua.util.DoctorRepository;
import java.time.LocalDate;
import java.util.List;



public class Main {

    public static void main(String[] args) {

        System.out.println("=== LR6: Stream API ===");

        PatientRepository patientRepo = new PatientRepository();
        DoctorRepository doctorRepo = new DoctorRepository();

        patientRepo.add(new Patient("Ivan", "Petrenko", "P1", LocalDate.of(2000, 5, 10)));
        patientRepo.add(new Patient("Olga", "Ivanova", "P2", LocalDate.of(1998, 3, 20)));
        patientRepo.add(new Patient("Andrii", "Petrenko", "P3", LocalDate.of(2002, 7, 5)));

        doctorRepo.add(new Doctor("Andrii", "Koval", Specialty.CARDIOLOGIST));
        doctorRepo.add(new Doctor("Iryna", "Shevchenko", Specialty.DERMATOLOGIST));
        doctorRepo.add(new Doctor("Petro", "Ivanov", Specialty.CARDIOLOGIST));

        System.out.println("\n--- Find patients by last name Petrenko ---");
        List<Patient> p1 = patientRepo.findByLastName("Petrenko");
        p1.forEach(System.out::println);

        System.out.println("\n--- Find patients by birth date range ---");
        patientRepo.findByBirthDateRange(
                LocalDate.of(1999, 1, 1),
                LocalDate.of(2002, 12, 31)
        ).forEach(System.out::println);

        System.out.println("\n--- Doctors by specialty (CARDIOLOGIST) ---");
        doctorRepo.findBySpecialty(Specialty.CARDIOLOGIST)
                .forEach(System.out::println);

        System.out.println("\n--- Reduce doctors last names ---");
        System.out.println(doctorRepo.reduceAllLastNames());

        System.out.println("\n--- Performance: stream vs parallelStream ---");

        long start1 = System.nanoTime();
        patientRepo.getAll().stream().forEach(p -> {});
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        patientRepo.getAll().parallelStream().forEach(p -> {});
        long end2 = System.nanoTime();

        System.out.println("Stream time: " + (end1 - start1));
        System.out.println("Parallel stream time: " + (end2 - start2));

        System.out.println("\n=== END LR6 ===");
    }
}
