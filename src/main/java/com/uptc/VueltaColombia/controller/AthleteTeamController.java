package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.dto.AthleteTeamDTO;
import com.uptc.VueltaColombia.dto.EditionTeamDTO;
import com.uptc.VueltaColombia.entity.AthleteTeam;
import com.uptc.VueltaColombia.entity.EditionTeam;
import com.uptc.VueltaColombia.service.AthleteTeamStoreService;
import com.uptc.VueltaColombia.service.EditionTeamStoreService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/athlete-team/")
public class AthleteTeamController {
    private static final Logger log = LoggerFactory.getLogger(AthleteTeamController.class);
    @Autowired
    private AthleteTeamStoreService service;


    @GetMapping("/find")
    public Optional<AthleteTeam> find(@RequestParam Long editionTeamId, @RequestParam Long athleteId) {
        log.info("Request to find");
        return service.findById(editionTeamId, athleteId);
    }

    @PostMapping("/store")
    public void store(@Valid @RequestBody AthleteTeamDTO object) {
        log.info("Request to store: \n{}", object);
        service.store(object);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody AthleteTeamDTO object) {
        log.info("Request to update: \n{}", object);
        service
            .find(object)
            .ifPresentOrElse(
                foundObject -> service.store(object),
                () -> log.error("Request to update not-found: \n{}", object)
            );
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long editionTeamId, @RequestParam Long athleteId) {
        log.info("Request to delete object: {} {}", editionTeamId, athleteId);
        service.delete(editionTeamId, athleteId);
    }
}
