package ua.util;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorRepository extends GenericRepository<Doctor> {

    public List<Doctor> findBySpecialty(Specialty specialty) {
        logger.info("Search doctors by specialty: " + specialty);
        return data.stream()
                .filter(d -> d.specialty() == specialty)
                .collect(Collectors.toList());
    }

    public String reduceAllLastNames() {
        return data.stream()
                .map(Doctor::lastName)
                .reduce("", (a, b) -> a + " " + b);
    }
}
