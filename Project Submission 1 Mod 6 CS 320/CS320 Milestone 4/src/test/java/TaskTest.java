import org.example.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Task class.
 * Validates that Task objects are created and behave as expected.
 */
class TaskTest {

    @Test
    void testTaskCreationSuccess() {
        // Valid Task creation
        Task task = new Task("123", "Sample Task", "This is a description.");
        assertEquals("123", task.getTaskId());
        assertEquals("Sample Task", task.getName());
        assertEquals("This is a description.", task.getDescription());
    }

    @Test
    void testTaskIdValidation() {
        // Invalid taskId cases
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Sample Task", "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Sample Task", "Description"));
    }

    @Test
    void testNameValidation() {
        // Invalid name cases
        assertThrows(IllegalArgumentException.class, () -> new Task("123", null, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "This name is way too long for validation.", "Description"));
    }

    @Test
    void testDescriptionValidation() {
        // Invalid description cases
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Sample Task", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Sample Task", "This description is way too long and exceeds the maximum allowed length of fifty characters."));
    }
}
