package ua.app;

import ua.util.*;
import java.time.LocalDate;

public class TestRunner {

    public static void main(String[] args) {

        GenericRepository<Patient> repo =
                new GenericRepository<>(Patient::patientId);

        Patient p1 = new Patient("Test", "One", "ID-1", LocalDate.of(2001, 1, 1));
        Patient p2 = new Patient("Test", "Two", "ID-2", LocalDate.of(2002, 2, 2));

        repo.add(p1);
        repo.add(p2);

        assert repo.getAll().size() == 2;
        assert repo.findByIdentity("ID-1").isPresent();
        assert repo.findByIdentity("ID-X").isEmpty();

        repo.remove(p1);
        assert repo.getAll().size() == 1;

        System.out.println("=== ALL TESTS PASSED ===");
    }
}
