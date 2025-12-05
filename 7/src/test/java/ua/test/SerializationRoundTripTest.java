package ua.test;

import org.junit.jupiter.api.Test;
import ua.model.Patient;
import ua.util.SerializationService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SerializationRoundTripTest {

    @Test
    void testPatientJsonRoundTrip() {
        SerializationService s = new SerializationService();
        List<Patient> list = List.of(new Patient("A","B","P1", LocalDate.of(2000,1,1)));
        s.saveJson("build/tmp/test_patients.json", list);
        List<Patient> loaded = s.loadJson("build/tmp/test_patients.json", Patient[].class);
        assertEquals(list, loaded);
    }

    @Test
    void testPatientYamlRoundTrip() {
        SerializationService s = new SerializationService();
        List<Patient> list = List.of(new Patient("X","Y","P2", LocalDate.of(1999,5,5)));
        s.saveYaml("build/tmp/test_patients.yaml", list);
        List<Patient> loaded = s.loadYaml("build/tmp/test_patients.yaml", Patient[].class);
        assertEquals(list, loaded);
    }
}
