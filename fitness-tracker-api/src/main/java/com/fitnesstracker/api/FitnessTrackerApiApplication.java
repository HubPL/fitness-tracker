package com.fitnesstracker.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fitnesstracker.core", "com.fitnesstracker.data", "com.fitnesstracker.api"})
public class FitnessTrackerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FitnessTrackerApiApplication.class, args);
    }
}