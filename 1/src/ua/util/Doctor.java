package ua.util;

public class Doctor extends Person {
    private String specialty;

    public Doctor(String fn, String ln, String sp) {
        super(fn, ln);
        setSpecialty(sp);
    }

    public static Doctor of(String fn, String ln, String sp) {
        return new Doctor(fn, ln, sp);
    }

    public String getSpecialty() { return specialty; }

    public void setSpecialty(String specialty) {
        if (!ValidationHelper.isValidText(specialty))
            throw new IllegalArgumentException("Invalid specialty");
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" + super.toString()
                + ", specialty='" + specialty + "'}";
    }
}
