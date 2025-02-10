package com.fitnesstracker.data.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String muscleGroup;

    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}