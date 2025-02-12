package com.patricia.listaTareas.controller;

import com.patricia.listaTareas.model.Category;
import com.patricia.listaTareas.model.Task;
import com.patricia.listaTareas.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired //inyecta directamente el servicio
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    //Obtiene la lista completa
    @GetMapping("")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    //obtiene tarea por id
    @GetMapping("/{id}")
    public ResponseEntity<String> getTaskById(@PathVariable Long id) {
        try {
            ResponseEntity.ok(taskService.getTaskById(id));
            return ResponseEntity.ok("✅ Tarea obtenida");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("❌ Error: No se encontró la tarea con ID " + id);
        }
    }
    //crear nueva tarea
    @PostMapping("")
    public ResponseEntity<String> createTask(@RequestBody Task taskDetails) {
        Task createdTask = taskService.createTask(taskDetails);
        return ResponseEntity.created(URI.create("/api/task/" + createdTask.getId()))
                .body("✅ Tarea creada");
    }


    // Actualizar una tarea completamente
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        try {
            taskService.updateTask(id,taskDetails);
            return ResponseEntity.ok("✅ Tarea con ID " + id + " actualizada " +taskDetails.toString());

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("❌ Error: No se encontró la tarea con ID " + id);
        }
    }
    //Actualización parcial de una tarea
    @PatchMapping("/{id}")
    public ResponseEntity<String> patchTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        try {
            taskService.updateTask(id, taskDetails);
            return ResponseEntity.ok("✅ Tarea con ID " + id + " actualizada " +taskDetails.toString());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("❌ Error: No se encontró la tarea con ID " + id);

        }
    }

    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.ok("✅Tarea eliminada");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body("❌ Error: No se encontró la tarea con ID " + id);
        }
    }
}
