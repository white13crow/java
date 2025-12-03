package ua.util;
public record Doctor(String firstName, String lastName, Specialty specialty) {
    public Doctor {
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("Invalid firstName");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Invalid lastName");
        if (specialty == null) throw new IllegalArgumentException("specialty null");
    }
}
