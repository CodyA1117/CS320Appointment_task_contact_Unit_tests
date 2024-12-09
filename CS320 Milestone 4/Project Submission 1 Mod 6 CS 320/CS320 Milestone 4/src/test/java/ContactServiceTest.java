import org.example.Contact;
import org.example.ContactService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    @Test
        // Tests that a contact can be added successfully and retrieved by its ID.
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    @Test
        // Tests that a contact can be deleted successfully and is no longer retrievable.
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test
    // Tests that a contact's fields (first name, last name, phone, address) can be updated.
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Elm Street");
        service.addContact(contact);
        service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Oak Street");
        assertEquals("Jane", service.getContact("12345").getFirstName());
        assertEquals("Smith", service.getContact("12345").getLastName());
        assertEquals("0987654321", service.getContact("12345").getPhone());
        assertEquals("456 Oak Street", service.getContact("12345").getAddress());
    }
}
