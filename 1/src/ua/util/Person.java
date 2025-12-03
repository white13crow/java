package ua.util;

import java.util.Objects;

public abstract class Person {
    protected String firstName;
    protected String lastName;

    public Person(String firstName, String lastName) {
        if (!ValidationHelper.isValidName(firstName) ||
            !ValidationHelper.isValidName(lastName))
            throw new IllegalArgumentException("Invalid name");

        this.firstName = Utils.formatName(firstName);
        this.lastName = Utils.formatName(lastName);
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return Objects.equals(firstName, p.firstName)
            && Objects.equals(lastName, p.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
