package org.example;

import java.util.HashMap;
import java.util.Map;

//Written By Cody Adams

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    // Adds a task if the ID is unique
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Deletes a task by its ID if it exists
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        tasks.remove(taskId);
    }

    // Updates the name of a task by its ID
    public void updateTaskName(String taskId, String name) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setName(name);
    }

    // Updates the description of a task by its ID
    public void updateTaskDescription(String taskId, String description) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found.");
        }
        task.setDescription(description);
    }

    // Retrieves a task by its ID
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}

