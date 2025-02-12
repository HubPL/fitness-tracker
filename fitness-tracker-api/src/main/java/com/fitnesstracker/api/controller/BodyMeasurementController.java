package com.fitnesstracker.api.controller;

import com.fitnesstracker.core.service.BodyMeasurementService;
import com.fitnesstracker.data.model.BodyMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class BodyMeasurementController {

    @Autowired
    private BodyMeasurementService bodyMeasurementService;

    @GetMapping
    public List<BodyMeasurement> getAllMeasurements() {
        return bodyMeasurementService.getAllMeasurements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyMeasurement> getMeasurementById(@PathVariable Long id) {
        return bodyMeasurementService.getMeasurementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<BodyMeasurement> getMeasurementsByUserId(@PathVariable Long userId) {
        return bodyMeasurementService.getMeasurementsByUserId(userId);
    }

    @GetMapping("/user/{userId}/range")
    public List<BodyMeasurement> getMeasurementsInDateRange(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return bodyMeasurementService.getMeasurementsForUserInDateRange(userId, startDate, endDate);
    }

    @PostMapping
    public BodyMeasurement createMeasurement(@RequestBody BodyMeasurement measurement) {
        return bodyMeasurementService.createMeasurement(measurement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyMeasurement> updateMeasurement(
            @PathVariable Long id,
            @RequestBody BodyMeasurement measurement) {
        return bodyMeasurementService.updateMeasurement(id, measurement)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasurement(@PathVariable Long id) {
        bodyMeasurementService.deleteMeasurement(id);
        return ResponseEntity.noContent().build();
    }
}