package ua.repo;

import ua.model.Doctor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class DoctorRepository {

    private static final Logger logger = Logger.getLogger(DoctorRepository.class.getName());
    private final List<Doctor> data = new ArrayList<>();

    public void add(Doctor d) {
        data.add(d);
        logger.info("Added doctor: " + d);
    }

    public List<Doctor> getAll() {
        return Collections.unmodifiableList(data);
    }

    public void clear() { data.clear(); logger.info("Cleared doctors"); }
}
