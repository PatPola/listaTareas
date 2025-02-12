# Lista de Tareas (Task List)

Este proyecto es una aplicación básica de gestión de tareas construida con Java y Spring Boot utilizando Gradle para las dependencias. 
Permite a los usuarios crear, leer, actualizar y eliminar tareas. La aplicación utiliza una base de datos H2 en memoria para almacenar las tareas.
Iré añadiendo mas funcionalidad, el siguiente update será utilizar una base de datos persistente

## Características

- **Crear tareas**: Permite agregar nuevas tareas con un nombre,categoria, descripción, fecha  y estado.
- **Obtener todas las tareas**: Muestra la lista de todas las tareas existentes en la base de datos.
- **Obtener una tarea por ID**: Permite ver los detalles de una tarea específica.
- **Actualizar tareas**: Permite modificar las tareas existentes.
- **Eliminar tareas**: Elimina tareas de la base de datos.
  
## Tecnologías utilizadas

- **Java**: Lenguaje de programación utilizado para construir la aplicación.
- **Spring Boot**: Framework utilizado para desarrollar la aplicación.
- **H2 Database**: Base de datos en memoria utilizada para almacenar las tareas.
- **Spring Data JPA**: Para interactuar con la base de datos.
- **Spring Web**: Para las operaciones RESTful (GET, POST, PUT, DELETE).
- **Lombok**: Librería que reduce la cantidad de código repetitivo al generar automáticamente métodos como `getters`, `setters`, `constructores`, etc.

## Desarrollado 

- **Java 21**.
- **Spring Boot 3.4.2**



