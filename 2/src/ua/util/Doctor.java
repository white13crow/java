package ua.util;

public record Doctor(
        String firstName,
        String lastName,
        Specialty specialty
) {
    public Doctor {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException("Invalid first name");
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException("Invalid last name");
        if (specialty == null)
            throw new IllegalArgumentException("Specialty is required");
    }
}
