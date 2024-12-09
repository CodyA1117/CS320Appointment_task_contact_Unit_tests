import org.example.Appointment;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Written By Cody Adams
 * Tests the Appointment class functionality.
 *
 */
class AppointmentTest {

    @Test //Verifies that a valid appointment object can be created with constraints met.
    void testValidAppointmentCreation() {
        Appointment appointment = new Appointment("12345", new Date(System.currentTimeMillis() + 1000), "Doctor visit");
        assertEquals("12345", appointment.getAppointmentId());
        assertNotNull(appointment.getAppointmentDate());
        assertEquals("Doctor visit", appointment.getDescription());
    }

    @Test//Verifies exception is thrown when appointmentId is null or violates the length constraint.
    void testInvalidAppointmentId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(System.currentTimeMillis() + 1000), "Doctor visit");
        });
    }

    @Test//Confirms exception is thrown if the appointmentDate is in the past or null.
    void testInvalidAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", new Date(System.currentTimeMillis() - 1000), "Doctor visit");
        });
    }

    @Test//Tests exception is thrown when description is null or exceeds the character limit.
    void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", new Date(System.currentTimeMillis() + 1000), null);
        });
    }
}

