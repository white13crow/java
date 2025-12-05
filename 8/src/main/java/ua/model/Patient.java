
package ua.model;

import ua.exception.InvalidDataException;
import java.time.LocalDate;

public class Patient {

    private int id;
    private String name;
    private LocalDate birthDate;

    public Patient(int id, String name, LocalDate birthDate) {
        setId(id);
        setName(name);
        setBirthDate(birthDate);
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

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null || birthDate.isAfter(LocalDate.now()))
            throw new InvalidDataException("birthDate: must be in the past");
        this.birthDate = birthDate;
    }
}
