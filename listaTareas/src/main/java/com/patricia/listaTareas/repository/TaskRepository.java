package com.patricia.listaTareas.repository;

import com.patricia.listaTareas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Clase que extiende del repositorio JPA y va a proporcionar los métodos
 * CRUD básicos y de paginacion, también podríamos añadir métodos personalizados
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}
