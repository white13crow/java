package ua.util;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PatientRepository extends GenericRepository<Patient> {

    public List<Patient> findByLastName(String lastName) {
        logger.info("Search patients by last name: " + lastName);
        return data.stream()
                .filter(p -> p.lastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    public List<Patient> findByBirthDateRange(LocalDate from, LocalDate to) {
        logger.info("Search patients by birth date range");
        return data.stream()
                .filter(p -> !p.birthDate().isBefore(from) && !p.birthDate().isAfter(to))
                .collect(Collectors.toList());
    }

    public long countPatients() {
        return data.stream().count();
    }
}
