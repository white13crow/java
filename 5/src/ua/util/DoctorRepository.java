package ua.util;

import java.util.logging.Logger;

public class DoctorRepository extends GenericRepository<Doctor> {

    private static final Logger logger =
            Logger.getLogger(DoctorRepository.class.getName());

    public DoctorRepository() {
        super(d -> d.firstName() + d.lastName());
    }

    public void sortBySpecialty() {
        storage.sort(Doctor.BY_SPECIALTY);
        logger.info("Sorted doctors by specialty");
    }

    public void sortByFirstName() {
        storage.sort(Doctor.BY_FIRSTNAME);
        logger.info("Sorted doctors by first name");
    }
}
