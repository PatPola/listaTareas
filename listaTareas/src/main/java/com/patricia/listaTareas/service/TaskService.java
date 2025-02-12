package com.patricia.listaTareas.service;

import com.patricia.listaTareas.model.Task;
import com.patricia.listaTareas.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TaskService {
    private final TaskRepository taskRepository;
    //inyección automática de una instancia de la interfz TaskRepository
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task existingTask = getTaskById(id);
        updateTaskDetails(existingTask, taskDetails);
        return taskRepository.save(existingTask);
    }
    private void updateTaskDetails(Task existingTask, Task taskDetails) {
        if (taskDetails.getName() != null) {
            existingTask.setName(taskDetails.getName());
        }
        if (taskDetails.getDescription() != null) {
            existingTask.setDescription(taskDetails.getDescription());
        }
        if (taskDetails.getCategory() != null) {
            existingTask.setCategory(taskDetails.getCategory());
        }
        if (taskDetails.getDueDate() != null) {
            existingTask.setDueDate(taskDetails.getDueDate());
        }
        existingTask.setStatus(taskDetails.isStatus()); // Si status es booleano, no puede ser null
    }


    public boolean deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new EntityNotFoundException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
        return true;
    }

}
