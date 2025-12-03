package ua.util;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class FileDataLoader {

    private static final Logger logger = Logger.getLogger(FileDataLoader.class.getName());

    static {
        try {
            Logger root = Logger.getLogger("");
            FileHandler fh = new FileHandler("app.log", true);
            fh.setFormatter(new SimpleFormatter());
            root.addHandler(fh);
            root.addHandler(new ConsoleHandler());
            root.setLevel(Level.INFO);
        } catch (IOException e) {
            System.err.println("Logger error: " + e.getMessage());
        }
    }

    public static List<Patient> loadPatients(String path) throws InvalidDataException {
        List<Patient> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int lineNo = 0;

            while ((line = br.readLine()) != null) {
                lineNo++;
                if (line.isBlank() || line.startsWith("#")) continue;

                String[] parts = line.split(",");
                if (parts.length < 4)
                    throw new InvalidDataException("Invalid format at line " + lineNo);

                try {
                    String fn = parts[0].trim();
                    String ln = parts[1].trim();
                    String id = parts[2].trim();
                    LocalDate bd = LocalDate.parse(parts[3].trim());

                    Patient p = new Patient(fn, ln, id, bd);
                    list.add(p);
                    logger.info("Created patient: " + p);

                } catch (DateTimeParseException | IllegalArgumentException ex) {
                    throw new InvalidDataException("Invalid data at line " + lineNo, ex);
                }
            }

        } catch (FileNotFoundException e) {
            throw new InvalidDataException("File not found: " + path, e);
        } catch (IOException e) {
            throw new InvalidDataException("File read error: " + path, e);
        }

        return list;
    }

    public static List<Doctor> loadDoctors(String path) throws InvalidDataException {
        List<Doctor> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int lineNo = 0;

            while ((line = br.readLine()) != null) {
                lineNo++;
                if (line.isBlank() || line.startsWith("#")) continue;

                String[] parts = line.split(",");
                if (parts.length < 3)
                    throw new InvalidDataException("Invalid format at line " + lineNo);

                try {
                    String fn = parts[0].trim();
                    String ln = parts[1].trim();
                    Specialty sp = Specialty.valueOf(parts[2].trim());

                    Doctor d = new Doctor(fn, ln, sp);
                    list.add(d);
                    logger.info("Created doctor: " + d);

                } catch (IllegalArgumentException ex) {
                    throw new InvalidDataException("Invalid data at line " + lineNo, ex);
                }
            }

        } catch (FileNotFoundException e) {
            throw new InvalidDataException("Doctor file not found: " + path, e);
        } catch (IOException e) {
            throw new InvalidDataException("Doctor file read error: " + path, e);
        }

        return list;
    }

    public static List<Medication> loadMedications(String path) throws InvalidDataException {
        List<Medication> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int lineNo = 0;

            while ((line = br.readLine()) != null) {
                lineNo++;
                if (line.isBlank() || line.startsWith("#")) continue;

                String[] parts = line.split(",");
                if (parts.length < 3)
                    throw new InvalidDataException("Invalid format at line " + lineNo);

                try {
                    String name = parts[0].trim();
                    String dosage = parts[1].trim();
                    MedicationType type = MedicationType.valueOf(parts[2].trim());

                    Medication m = new Medication(name, dosage, type);
                    list.add(m);
                    logger.info("Created medication: " + m);

                } catch (IllegalArgumentException ex) {
                    throw new InvalidDataException("Invalid data at line " + lineNo, ex);
                }
            }

        } catch (FileNotFoundException e) {
            throw new InvalidDataException("Medication file not found: " + path, e);
        } catch (IOException e) {
            throw new InvalidDataException("Medication file read error: " + path, e);
        }

        return list;
    }

    public static int countLines(String path) throws InvalidDataException {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.readLine() != null) count++;
            logger.info("Lines in file " + path + ": " + count);

        } catch (IOException ex) {
            throw new InvalidDataException("Line count error: " + path, ex);
        }

        return count;
    }
}
