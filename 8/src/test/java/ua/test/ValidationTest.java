
package ua.test;

import org.junit.jupiter.api.Test;
import ua.exception.InvalidDataException;
import ua.model.Patient;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    @Test
    void validPatientCreated() {
        assertDoesNotThrow(() ->
                new Patient(1, "Test", LocalDate.of(2000,1,1)));
    }

    @Test
    void invalidPatientThrowsException() {
        InvalidDataException ex = assertThrows(InvalidDataException.class, () ->
                new Patient(-1, "", LocalDate.now().plusDays(1))
        );
        assertTrue(ex.getMessage().contains("id"));
    }
}
