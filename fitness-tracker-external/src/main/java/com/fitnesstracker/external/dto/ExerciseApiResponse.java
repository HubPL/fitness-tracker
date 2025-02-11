package com.fitnesstracker.external.dto;

import lombok.Data;
import java.util.List;

@Data
public class ExerciseApiResponse {
    private String bodyPart;
    private String equipment;
    private String gifUrl;
    private String id;
    private String name;
    private String target;
    private List<String> secondaryMuscles;
    private List<String> instructions;
}