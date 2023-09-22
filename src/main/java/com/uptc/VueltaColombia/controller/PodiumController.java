package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.dto.PodiumDTO;
import com.uptc.VueltaColombia.entity.Athlete;
import com.uptc.VueltaColombia.entity.Podium;
import com.uptc.VueltaColombia.entity.Stage;
import com.uptc.VueltaColombia.entity.key.PodiumPK;
import com.uptc.VueltaColombia.repository.AthleteRepository;
import com.uptc.VueltaColombia.repository.PodiumRepository;
import com.uptc.VueltaColombia.repository.StageRepository;
import com.uptc.VueltaColombia.service.PodiumStoreService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/podium/")
public class PodiumController {
    private static final Logger log = LoggerFactory.getLogger(PodiumController.class);
    @Autowired
    private PodiumStoreService service;

    @GetMapping("/find")
    public Optional<Podium> find(@RequestParam Long stageId, @RequestParam Long athleteId) {
        log.info("Request to find object: \n{}, {}", stageId, athleteId);
        return service.find(stageId, athleteId);
    }

    @PostMapping("/store")
    public void store(@RequestBody PodiumDTO object) {
        log.info("Request to store object: \n{}", object);
        service.store(object);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody PodiumDTO object, @RequestParam Long stageId, @RequestParam Long athleteId) {
        log.info("Request to update object: \n{}", object);

        service
            .find(stageId, athleteId)
            .ifPresentOrElse(
                foundObject -> service.store(object),
                () -> log.error("Request to update not-found object: \n{}", object)
            );
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long stageId, @RequestParam Long athleteId) {
        log.info("Request to delete object: \n{}, {}", stageId, athleteId);
        service.delete(stageId, athleteId);
    }
}
