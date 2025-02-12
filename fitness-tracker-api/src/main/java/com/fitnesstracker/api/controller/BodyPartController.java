package com.fitnesstracker.api.controller;

import com.fitnesstracker.core.service.BodyPartService;
import com.fitnesstracker.data.model.BodyPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/body-parts")
public class BodyPartController {

    @Autowired
    private BodyPartService bodyPartService;

    @GetMapping
    public List<BodyPart> getAllBodyParts() {
        return bodyPartService.getAllBodyParts();
    }

    @GetMapping("/active")
    public List<BodyPart> getActiveBodyParts() {
        return bodyPartService.getAllActiveBodyParts();
    }

    @GetMapping("/active/sorted")
    public List<BodyPart> getActiveBodyPartsSorted() {
        return bodyPartService.getAllActiveBodyPartsSorted();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyPart> getBodyPartById(@PathVariable Long id) {
        return bodyPartService.getBodyPartById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BodyPart createBodyPart(@RequestBody BodyPart bodyPart) {
        return bodyPartService.createBodyPart(bodyPart);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyPart> updateBodyPart(
            @PathVariable Long id,
            @RequestBody BodyPart bodyPart) {
        return bodyPartService.updateBodyPart(id, bodyPart)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<BodyPart> setBodyPartActiveStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return bodyPartService.setBodyPartActiveStatus(id, active)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBodyPart(@PathVariable Long id) {
        bodyPartService.deleteBodyPart(id);
        return ResponseEntity.noContent().build();
    }
}