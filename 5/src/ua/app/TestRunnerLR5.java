package ua.app;

import ua.util.*;
import java.time.LocalDate;

public class TestRunnerLR5 {

    public static void main(String[] args) {

        PatientRepository repo = new PatientRepository();

        repo.add(new Patient("Ivan", "Petrenko", "P3",
                LocalDate.of(2000, 5, 10)));
        repo.add(new Patient("Olga", "Ivanova", "P1",
                LocalDate.of(1999, 3, 20)));
        repo.add(new Patient("Andrii", "Shevchenko", "P2",
                LocalDate.of(2001, 7, 5)));

        repo.sortByIdentity("asc");
        assert repo.getAll().get(0).patientId().equals("P1");

        repo.sortByLastName();
        assert repo.getAll().get(0).lastName().equals("Ivanova");

        repo.sortByBirthDate();
        assert repo.getAll().get(0).birthDate().equals(
                LocalDate.of(1999, 3, 20));

        System.out.println("=== LR5 SORT TESTS PASSED ===");
    }
}
