package com.fitnesstracker.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "body_parts")
@Data
public class BodyPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private boolean active = true;
}