
package ua.repo;

import ua.model.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {
    private final List<Doctor> doctors = new ArrayList<>();

    public void add(Doctor d) {
        doctors.add(d);
    }

    public List<Doctor> findAll() {
        return doctors;
    }
}
