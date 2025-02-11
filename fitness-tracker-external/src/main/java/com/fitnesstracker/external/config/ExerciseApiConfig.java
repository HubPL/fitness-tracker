package com.fitnesstracker.external.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "exercise.api")
@Data
public class ExerciseApiConfig {
    private String apiKey;
    private String apiHost;
    private String baseUrl;
}