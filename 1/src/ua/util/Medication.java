package ua.util;

public class Medication {
    private String name;
    private String dosage;
    private String instructions;

    public Medication(String n, String d, String i) {
        setName(n);
        setDosage(d);
        setInstructions(i);
    }

    public static Medication of(String n, String d, String i) {
        return new Medication(n, d, i);
    }

    public void setName(String n) {
        if (!ValidationHelper.isValidText(n))
            throw new IllegalArgumentException("Invalid medication name");
        this.name = n;
    }

    public void setDosage(String d) {
        if (!ValidationHelper.isValidDosage(d))
            throw new IllegalArgumentException("Invalid dosage");
        this.dosage = d;
    }

    public void setInstructions(String i) {
        if (!ValidationHelper.isValidText(i))
            throw new IllegalArgumentException("Invalid instructions");
        this.instructions = i;
    }

    @Override
    public String toString() {
        return name + " (" + dosage + "): " + instructions;
    }
}
