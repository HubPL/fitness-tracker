package com.fitnesstracker.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.fitnesstracker.api",
        "com.fitnesstracker.core",
        "com.fitnesstracker.data",
})
@EntityScan(basePackages = "com.fitnesstracker.data.model")
@EnableJpaRepositories(basePackages = "com.fitnesstracker.data.repository")
public class FitnessTrackerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FitnessTrackerApiApplication.class, args);
    }
}