package com.fitnesstracker.data.repository;

import com.fitnesstracker.data.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {
    List<Exercise> findByBodyPart(String bodyPart);
    List<Exercise> findByTarget(String targetMuscle);
    List<Exercise> findByEquipment(String equipment);
}