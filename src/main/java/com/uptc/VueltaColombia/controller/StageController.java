package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.dto.StageDTO;
import com.uptc.VueltaColombia.entity.Stage;
import com.uptc.VueltaColombia.repository.StageRepository;
import com.uptc.VueltaColombia.service.StageStoreService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/stage/")
public class StageController {
    private static final Logger log = LoggerFactory.getLogger(EditionController.class);
    @Autowired
    private StageStoreService service;

    @GetMapping("/find")
    public Optional<Stage> find(@RequestParam Long id) {
        log.info("Request to find object: \n{}", id);
        return service.repository.findById(id);
    }

    @PostMapping("/store")
    public void store(@Valid @RequestBody StageDTO object) {
        log.info("Request to store object: \n{}", object);
        service.store(object);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody StageDTO object) {
        log.info("Request to update object: \n{}", object);
        service.repository
            .findById(object.id)
            .ifPresentOrElse(
                foundObject -> service.store(object),
                () -> log.error("Request to update not-found object: \n{}", object)
            );
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        log.info("Request to delete object: {}", id);
        service.repository.deleteById(id);
    }
}
