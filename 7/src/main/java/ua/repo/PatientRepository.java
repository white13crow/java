package ua.repo;

import ua.model.Patient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class PatientRepository {

    private static final Logger logger = Logger.getLogger(PatientRepository.class.getName());
    private final List<Patient> data = new ArrayList<>();

    public void add(Patient p) {
        data.add(p);
        logger.info("Added patient: " + p);
    }

    public List<Patient> getAll() {
        return Collections.unmodifiableList(data);
    }

    public void clear() { data.clear(); logger.info("Cleared patients"); }
}
