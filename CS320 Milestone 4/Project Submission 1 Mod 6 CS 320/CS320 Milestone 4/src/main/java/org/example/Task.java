package org.example;

/**
 * Written By Cody Adams
 * Task class represents a single task with an ID, name, and description.
 * Includes validation to ensure the ID, name, and description adhere to the specified constraints.
 */
public class Task {
    private final String taskId; // Unique ID for the task; cannot be changed after initialization
    private String name;        // Name of the task
    private String description; // Description of the task

    // Constructor: Validates and initializes a Task object
    public Task(String taskId, String name, String description) {
        // Validate taskId: Must not be null and cannot exceed 10 characters
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID must be non-null and up to 10 characters.");
        }
        // Validate name: Must not be null and cannot exceed 20 characters
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be non-null and up to 20 characters.");
        }
        // Validate description: Must not be null and cannot exceed 50 characters
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and up to 50 characters.");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getter for taskId
    public String getTaskId() {
        return taskId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for name with validation
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name must be non-null and up to 20 characters.");
        }
        this.name = name;
    }

    // Setter for description with validation
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and up to 50 characters.");
        }
        this.description = description;
    }
}

