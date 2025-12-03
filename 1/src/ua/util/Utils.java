package ua.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Utils {

    public static String formatName(String n) {
        if (!ValidationHelper.isValidName(n))
            throw new IllegalArgumentException("Invalid name");
        return n.trim().substring(0,1).toUpperCase()
                + n.trim().substring(1).toLowerCase();
    }

    public static String generatePatientId(String lastName) {
        return lastName.toUpperCase().substring(0,2)
                + "-" + System.currentTimeMillis()%10000;
    }

    public static String formatDateTime(LocalDateTime dt) {
        return dt.toString().replace("T", " ");
    }
}
