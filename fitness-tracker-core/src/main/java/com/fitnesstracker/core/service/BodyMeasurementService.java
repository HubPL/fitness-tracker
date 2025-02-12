package com.fitnesstracker.core.service;

import com.fitnesstracker.data.model.BodyMeasurement;
import com.fitnesstracker.data.repository.BodyMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BodyMeasurementService {

    @Autowired
    private BodyMeasurementRepository bodyMeasurementRepository;

    public List<BodyMeasurement> getAllMeasurements() {
        return bodyMeasurementRepository.findAll();
    }

    public Optional<BodyMeasurement> getMeasurementById(Long id) {
        return bodyMeasurementRepository.findById(id);
    }

    public List<BodyMeasurement> getMeasurementsByUserId(Long userId) {
        return bodyMeasurementRepository.findByUserIdOrderByMeasurementDateDesc(userId);
    }

    public List<BodyMeasurement> getMeasurementsForUserInDateRange(Long userId, LocalDate startDate, LocalDate endDate) {
        return bodyMeasurementRepository.findByUserIdAndMeasurementDateBetween(userId, startDate, endDate);
    }

    public BodyMeasurement createMeasurement(BodyMeasurement measurement) {
        measurement.setMeasurementDate(LocalDate.now());
        return bodyMeasurementRepository.save(measurement);
    }

    public Optional<BodyMeasurement> updateMeasurement(Long id, BodyMeasurement updatedMeasurement) {
        return bodyMeasurementRepository.findById(id)
                .map(existingMeasurement -> {
                    updatedMeasurement.setId(id);
                    updatedMeasurement.setUser(existingMeasurement.getUser());
                    return bodyMeasurementRepository.save(updatedMeasurement);
                });
    }

    public void deleteMeasurement(Long id) {
        bodyMeasurementRepository.deleteById(id);
    }
}