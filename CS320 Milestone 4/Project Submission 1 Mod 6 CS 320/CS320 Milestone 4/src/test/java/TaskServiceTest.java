import org.example.Task;
import org.example.TaskService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the TaskService class.
 * Validates the functionality of adding, updating, and deleting tasks.
 */
class TaskServiceTest {

    @Test
    void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Sample Task", "Description");

        // Add a task and verify it's stored
        service.addTask(task);
        assertEquals(task, service.getTask("123"));
    }

    @Test
    void testAddTaskWithDuplicateId() {
        TaskService service = new TaskService();
        Task task1 = new Task("123", "Task 1", "Description 1");
        Task task2 = new Task("123", "Task 2", "Description 2");

        // Adding a duplicate ID should throw an exception
        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task2));
    }

    @Test
    void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Sample Task", "Description");
        service.addTask(task);

        // Delete the task and verify it's removed
        service.deleteTask("123");
        assertNull(service.getTask("123"));
    }

    @Test
    void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Old Name", "Description");
        service.addTask(task);

        // Update the task's name
        service.updateTaskName("123", "New Name");
        assertEquals("New Name", service.getTask("123").getName());
    }

    @Test
    void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("123", "Sample Task", "Old Description");
        service.addTask(task);

        // Update the task's description
        service.updateTaskDescription("123", "New Description");
        assertEquals("New Description", service.getTask("123").getDescription());
    }
}

