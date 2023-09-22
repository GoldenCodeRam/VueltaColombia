package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.entity.Stage;
import com.uptc.VueltaColombia.entity.Team;
import com.uptc.VueltaColombia.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/team/")
public class TeamController {
    private static final Logger log = LoggerFactory.getLogger(EditionController.class);
    @Autowired
    private TeamRepository repository;

    @GetMapping("/find")
    public Optional<Team> find(@RequestParam Long id) {
        log.info("Request to find object: \n{}", id);
        return repository.findById(id);
    }

    @PostMapping("/store")
    public void store(@RequestBody Team object) {
        log.info("Request to store object: \n{}", object);
        repository.save(object);
    }

    @PutMapping("/update")
    public void update(@RequestBody Team object) {
        log.info("Request to update object: \n{}", object);
        repository
            .findById(object.getId())
            .ifPresentOrElse(
                foundObject -> repository.save(object),
                () -> log.error("Request to update not-found object: \n{}", object)
            );
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        log.info("Request to delete object: {}", id);
        repository.deleteById(id);
    }
}
