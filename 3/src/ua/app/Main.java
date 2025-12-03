package ua.app;

import ua.util.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== LR3: Обробка виключень & Файли ===");

        // Шляхи до файлів (поклади в project-root/data/)
        String patientsFile = "data/patients.csv";
        String doctorsFile = "data/doctors.csv";
        String medsFile = "data/medications.csv";

        // Приклад: multi-catch у виклику countLines
        try {
            int lines = FileDataLoader.countLines(patientsFile);
            System.out.println("Пацієнтів у файлі: " + lines);
        } catch (InvalidDataException e) {
            System.err.println("Не вдалося порахувати рядки: " + e.getMessage());
        }

        // Завантаження даних з файлів — приклад з try-catch-finally
        List<Patient> patients = null;
        List<Doctor> doctors = null;
        List<Medication> meds = null;

        try {
            patients = FileDataLoader.loadPatients(patientsFile);
            doctors = FileDataLoader.loadDoctors(doctorsFile);
            meds = FileDataLoader.loadMedications(medsFile);

            System.out.println("--- Успішно завантажено ---");
            patients.forEach(System.out::println);
            doctors.forEach(System.out::println);
            meds.forEach(System.out::println);

        } catch (InvalidDataException e) {
            // Обробка власного виключення — логування та вивід
            System.err.println("Помилка під час завантаження: " + e.getMessage());
            // лог вже зроблений у FileDataLoader
        } catch (RuntimeException e) {
            // по-безпечному — ловимо непередбачувані Runtime
            System.err.println("Несподівана помилка: " + e.getMessage());
        } finally {
            System.out.println("Завершено спробу завантаження (finally)");
        }

        System.out.println("=== Кінець Main ===");
    }
}
