
package ua.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.exception.InvalidDataException;
import ua.model.Doctor;
import ua.model.Patient;
import ua.repo.DoctorRepository;
import ua.repo.PatientRepository;

import java.time.LocalDate;

public class MainLR8 {

    private static final Logger logger = LoggerFactory.getLogger(MainLR8.class);

    public static void main(String[] args) {

        PatientRepository patientRepo = new PatientRepository();
        DoctorRepository doctorRepo = new DoctorRepository();

        try {
            logger.info("Creating valid Patient");
            Patient p1 = new Patient(1, "Ivan", LocalDate.of(2000,3,3));
            patientRepo.add(p1);
            logger.info("Patient added successfully");

            logger.info("Creating valid Doctor");
            Doctor d1 = new Doctor(1, "Dr. House", "Diagnostics");
            doctorRepo.add(d1);
            logger.info("Doctor added successfully");

        } catch (InvalidDataException e) {
            logger.error("Validation error: {}", e.getMessage());
        }

        try {
            logger.info("Creating invalid Patient");
            Patient p2 = new Patient(-1, "", LocalDate.now().plusDays(1));
            patientRepo.add(p2);
        } catch (InvalidDataException e) {
            logger.error("Validation failed: {}", e.getMessage());
        }
    }
}
