package com.fitnesstracker.core.service;

import com.fitnesstracker.data.model.BodyPart;
import com.fitnesstracker.data.repository.BodyPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodyPartService {

    @Autowired
    private BodyPartRepository bodyPartRepository;

    public List<BodyPart> getAllBodyParts() {
        return bodyPartRepository.findAll();
    }

    public List<BodyPart> getAllActiveBodyParts() {
        return bodyPartRepository.findByActiveTrue();
    }

    public List<BodyPart> getAllActiveBodyPartsSorted() {
        return bodyPartRepository.findByActiveTrueOrderByNameAsc();
    }

    public Optional<BodyPart> getBodyPartById(Long id) {
        return bodyPartRepository.findById(id);
    }

    public BodyPart createBodyPart(BodyPart bodyPart) {
        return bodyPartRepository.save(bodyPart);
    }

    public Optional<BodyPart> updateBodyPart(Long id, BodyPart updatedBodyPart) {
        return bodyPartRepository.findById(id)
                .map(existingBodyPart -> {
                    existingBodyPart.setName(updatedBodyPart.getName());
                    existingBodyPart.setActive(updatedBodyPart.isActive());
                    return bodyPartRepository.save(existingBodyPart);
                });
    }

    public Optional<BodyPart> setBodyPartActiveStatus(Long id, boolean active) {
        return bodyPartRepository.findById(id)
                .map(bodyPart -> {
                    bodyPart.setActive(active);
                    return bodyPartRepository.save(bodyPart);
                });
    }

    public void deleteBodyPart(Long id) {
        bodyPartRepository.deleteById(id);
    }
}