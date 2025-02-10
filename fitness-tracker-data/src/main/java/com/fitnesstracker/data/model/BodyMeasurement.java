package com.fitnesstracker.data.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class BodyMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate measurementDate;

    private Double weight;
    private Double bodyFatPercentage;
    private Double chest;
    private Double biceps;
    private Double waist;
    private Double hips;
    private Double thigh;
}