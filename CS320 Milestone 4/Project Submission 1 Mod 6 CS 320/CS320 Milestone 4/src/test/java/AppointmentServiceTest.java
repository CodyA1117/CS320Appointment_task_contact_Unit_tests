import org.example.Appointment;
import org.example.AppointmentService;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Written By Cody Adams
 * Tests the AppointmentService class functionality.
 */
class AppointmentServiceTest {

    @Test//tests that a new appointment can be successfully added to the service, and it is retreavvle by its ID.
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("12345", new Date(System.currentTimeMillis() + 1000), "Doctor visit");
        service.addAppointment(appointment);

        assertEquals(appointment, service.getAppointment("12345"));
    }

    @Test//Ensures that adding an Appointment with a duplicate appointmentId throws an exeption, preserving uniqueness.
    void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("12345", new Date(System.currentTimeMillis() + 1000), "Doctor visit");
        service.addAppointment(appointment);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(new Appointment("12345", new Date(System.currentTimeMillis() + 2000), "Another visit"));
        });
    }

    @Test//Verifies that an appointment can be successfully deleted by its ID, and its no longer retrevable.
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("12345", new Date(System.currentTimeMillis() + 1000), "Doctor visit");
        service.addAppointment(appointment);
        service.deleteAppointment("12345");

        assertNull(service.getAppointment("12345"));
    }

    @Test//Confirms that trying to delete an appointment with an ID that doesnt exist throws an exception.
    void testDeleteNonexistentAppointment() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("99999");
        });
    }
}
