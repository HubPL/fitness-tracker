package com.fitnesstracker.data.repository;

import com.fitnesstracker.data.model.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodyPartRepository extends JpaRepository<BodyPart, Long> {
    List<BodyPart> findByActiveTrue();
    List<BodyPart> findByActiveTrueOrderByNameAsc();
}