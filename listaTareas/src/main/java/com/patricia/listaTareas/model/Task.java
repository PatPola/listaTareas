package com.patricia.listaTareas.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter @Setter @ToString(exclude = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    String name;
    @NonNull
    private String description;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Category category;
    @NonNull
    private LocalDate dueDate;
    private boolean status;




}
