package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.entity.Athlete;
import com.uptc.VueltaColombia.repository.AthleteRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/athlete/")
public class AthleteController {
    private static final Logger log = LoggerFactory.getLogger(AthleteController.class);
    @Autowired
    private AthleteRepository repository;

    @GetMapping("/find")
    public Optional<Athlete> find(@RequestParam Long id) {
        log.info("Request to find athlete");
        return repository.findById(id);
    }

    @PostMapping("/store")
    public void store(@Valid @RequestBody Athlete object) {
        log.info("Request to store athlete: \n{}", object);
        repository.save(object);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody Athlete object) {
        log.info("Request to update athlete: \n{}", object);
        repository
            .findById(object.getId())
            .ifPresentOrElse(
                foundObject -> repository.save(object),
                () -> log.error("Request to update not-found athlete: \n{}", object)
            );
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        log.info("Request to delete object: {}", id);
        repository.deleteById(id);
    }
}
