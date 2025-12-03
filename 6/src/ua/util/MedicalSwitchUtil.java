package ua.util;

public class MedicalSwitchUtil {

    public static double getVisitPrice(Specialty specialty) {
        return switch (specialty) {
            case GENERAL_PRACTITIONER -> 400;
            case PEDIATRICIAN -> 450;
            case DERMATOLOGIST -> 500;
            case CARDIOLOGIST -> 700;
            case NEUROLOGIST -> 900;
        };
    }

    public static String getStatusMessage(AppointmentStatus status) {
        switch (status) {
            case SCHEDULED:
                return "Visit is scheduled";
            case COMPLETED:
                return "Visit completed successfully";
            case CANCELED:
                return "Visit was canceled";
            case NO_SHOW:
                return "Patient did not come";
            default:
                return "Unknown status";
        }
    }
}
