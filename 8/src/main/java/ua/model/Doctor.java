
package ua.model;

import ua.exception.InvalidDataException;

public class Doctor {

    private int id;
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        setId(id);
        setName(name);
        setSpecialization(specialization);
    }

    public void setId(int id) {
        if (id <= 0)
            throw new InvalidDataException("id: must be > 0");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new InvalidDataException("name: cannot be empty");
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.isBlank())
            throw new InvalidDataException("specialization: cannot be empty");
        this.specialization = specialization;
    }
}
