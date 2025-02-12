package com.fitnesstracker.data.repository;

import com.fitnesstracker.data.model.BodyMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BodyMeasurementRepository extends JpaRepository<BodyMeasurement, Long> {
    List<BodyMeasurement> findByUserIdOrderByMeasurementDateDesc(Long userId);
    List<BodyMeasurement> findByUserIdAndMeasurementDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}