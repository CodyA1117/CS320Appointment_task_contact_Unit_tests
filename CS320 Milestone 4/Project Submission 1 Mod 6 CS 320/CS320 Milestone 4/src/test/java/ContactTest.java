import org.example.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
        // Tests that a contact object can be initialized with valid data.
    void testContactInitialization() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Elm St", contact.getAddress());
    }

    @Test
        // Tests that an exception is thrown if the contact ID is null or invalid.
    void testContactInvalidId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Elm St");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
        // Tests that the update methods for first name, last name, phone, and address work correctly.
    void testContactUpdateMethods() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak St");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak St", contact.getAddress());
    }
}
