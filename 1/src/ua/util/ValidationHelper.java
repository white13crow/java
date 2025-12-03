package ua.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

class ValidationHelper {

    static boolean isValidName(String s) {
        return s != null && !s.trim().isEmpty();
    }

    static boolean isValidId(String id) {
        return id != null && id.matches("[A-Z0-9\\-]{4,20}");
    }

    static boolean isValidDate(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }

    static boolean isValidDateTime(LocalDateTime dt) {
        return dt != null;
    }

    static boolean isValidText(String s) {
        return s != null && !s.trim().isEmpty();
    }

    static boolean isValidDosage(String d) {
        return d != null && !d.trim().isEmpty();
    }
}
