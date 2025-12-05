package ua.model;

import java.time.LocalDate;

public record Patient(String firstName, String lastName, String patientId, LocalDate birthDate) { }
