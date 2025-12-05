
package ua.repo;

import ua.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private final List<Patient> patients = new ArrayList<>();

    public void add(Patient p) {
        patients.add(p);
    }

    public List<Patient> findAll() {
        return patients;
    }
}
