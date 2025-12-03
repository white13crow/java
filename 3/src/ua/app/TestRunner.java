package ua.app;

import ua.util.*;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Simple tests ===");

        // Підготувати тимчасові файли у data/
        Files.createDirectories(Paths.get("data"));

        String goodPatients =
                "Ivan,Petrenko,P-100,2000-05-10\n" +
                "Anna,Shevchuk,P-101,1995-02-20\n";
        Files.writeString(Paths.get("data/patients_test_good.csv"), goodPatients);

        String badPatients =
                "Ivan,,P-200,2000-05-10\n" +  // пусте прізвище -> invalid
                "Bad,Line\n";
        Files.writeString(Paths.get("data/patients_test_bad.csv"), badPatients);

        // TEST 1: коректне завантаження
        try {
            List<Patient> list = FileDataLoader.loadPatients("data/patients_test_good.csv");
            if (list.size() == 2) System.out.println("[PASS] loadPatients good");
            else System.out.println("[FAIL] loadPatients good - unexpected size");
        } catch (InvalidDataException e) {
            System.out.println("[FAIL] loadPatients good - threw: " + e.getMessage());
        }

        // TEST 2: не коректні дані -> очікуємо InvalidDataException
        try {
            FileDataLoader.loadPatients("data/patients_test_bad.csv");
            System.out.println("[FAIL] loadPatients bad - expected exception");
        } catch (InvalidDataException e) {
            System.out.println("[PASS] loadPatients bad - caught InvalidDataException");
        }

        // TEST 3: створення record з некоректними даними (перевірка в конструкторі record)
        try {
            Patient p = new Patient("", "Ivanov", "P-1", LocalDate.of(1990, 1, 1));
            System.out.println("[FAIL] Patient constructor - expected exception for empty firstName");
        } catch (IllegalArgumentException e) {
            System.out.println("[PASS] Patient constructor invalid name caught");
        }

        System.out.println("=== Tests finished ===");
    }
}
