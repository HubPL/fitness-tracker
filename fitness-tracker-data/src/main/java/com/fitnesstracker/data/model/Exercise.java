package com.fitnesstracker.data.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "exercises")
@Data
public class Exercise {
    @Id
    private String id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "body_part", nullable = false)
    private String bodyPart;

    @Column(nullable = false)
    private String equipment;

    @Column(name = "gif_url")
    private String gifUrl;

    @Column(name = "target_muscle")
    private String target;

    @ElementCollection
    @CollectionTable(
            name = "exercise_secondary_muscles",
            joinColumns = @JoinColumn(name = "exercise_id")
    )
    @Column(name = "muscle_name")
    private List<String> secondaryMuscles;

    @ElementCollection
    @CollectionTable(
            name = "exercise_instructions",
            joinColumns = @JoinColumn(name = "exercise_id")
    )
    @Column(name = "instruction_step", length = 500)
    @OrderColumn(name = "step_order")
    private List<String> instructions;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "external_source")
    private String externalSource = "EXERCISE_DB_API";
}