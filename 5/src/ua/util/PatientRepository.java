package ua.util;

import java.util.logging.Logger;

public class PatientRepository extends GenericRepository<Patient> {

    private static final Logger logger =
            Logger.getLogger(PatientRepository.class.getName());

    public PatientRepository() {
        super(Patient::patientId);
    }

    public void sortByLastName() {
        storage.sort(Patient.BY_LASTNAME);
        logger.info("Sorted patients by last name");
    }

    public void sortByBirthDate() {
        storage.sort(Patient.BY_BIRTHDATE);
        logger.info("Sorted patients by birth date");
    }
}
