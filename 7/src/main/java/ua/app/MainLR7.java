package ua.app;

import ua.model.Patient;
import ua.model.Doctor;
import ua.repo.PatientRepository;
import ua.repo.DoctorRepository;
import ua.util.SerializationService;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class MainLR7 {

    private static final Logger logger = Logger.getLogger(MainLR7.class.getName());

    public static void main(String[] args) {
        try {
            Properties p = new Properties();
            try (InputStream is = MainLR7.class.getClassLoader().getResourceAsStream("config.properties")) {
                if (is == null) throw new IllegalStateException("config.properties not found");
                p.load(is);
            }

            String jp = p.getProperty("json.patients"); String yp = p.getProperty("yaml.patients");
            String jd = p.getProperty("json.doctors"); String yd = p.getProperty("yaml.doctors");
            int count = Integer.parseInt(p.getProperty("test.data.count", "3"));

            PatientRepository pr = new PatientRepository();
            DoctorRepository dr = new DoctorRepository();

            for (int i=1;i<=count;i++) {
                pr.add(new Patient("Name"+i, "Last"+i, "P"+i, LocalDate.of(1990+i,1,1)));
                dr.add(new Doctor("DocFirst"+i, "DocLast"+i, "Specialty"+i));
            }

            SerializationService s = new SerializationService();

            s.saveJson(jp, pr.getAll());
            s.saveYaml(yp, pr.getAll());

            s.saveJson(jd, dr.getAll());
            s.saveYaml(yd, dr.getAll());

            List<Patient> lpj = s.loadJson(jp, Patient[].class);
            List<Patient> lpy = s.loadYaml(yp, Patient[].class);
            List<Doctor> ldj = s.loadJson(jd, Doctor[].class);
            List<Doctor> ldy = s.loadYaml(yd, Doctor[].class);

            logger.info("Patients JSON == YAML: " + (lpj.equals(lpy)));
            logger.info("Doctors JSON == YAML: " + (ldj.equals(ldy)));

            System.out.println("JSON patients equals original: " + pr.getAll().equals(lpj));
            System.out.println("YAML patients equals original: " + pr.getAll().equals(lpy));
            System.out.println("JSON doctors equals original: " + dr.getAll().equals(ldj));
            System.out.println("YAML doctors equals original: " + dr.getAll().equals(ldy));

        } catch (Exception e) {
            logger.severe("Fatal error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
