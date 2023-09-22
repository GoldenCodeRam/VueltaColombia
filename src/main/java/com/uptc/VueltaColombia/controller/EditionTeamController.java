package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.dto.EditionTeamDTO;
import com.uptc.VueltaColombia.entity.EditionTeam;
import com.uptc.VueltaColombia.entity.Sponsor;
import com.uptc.VueltaColombia.service.EditionTeamStoreService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/edition-team/")
public class EditionTeamController {
    private static final Logger log = LoggerFactory.getLogger(EditionTeamController.class);
    @Autowired
    private EditionTeamStoreService service;


    @GetMapping("/find")
    public Optional<EditionTeam> find(@RequestParam Long id) {
        log.info("Request to find");
        return service.repository.findById(id);
    }

    @PostMapping("/store")
    public void store(@Valid @RequestBody EditionTeamDTO object) {
        log.info("Request to store: \n{}", object);
        service.store(object);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody EditionTeamDTO object) {
        log.info("Request to update: \n{}", object);
        service
            .repository
            .findById(object.id)
            .ifPresentOrElse(
                foundObject -> service.store(object),
                () -> log.error("Request to update not-found: \n{}", object)
            );
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        log.info("Request to delete object: {}", id);
        service.repository.deleteById(id);
    }
}
