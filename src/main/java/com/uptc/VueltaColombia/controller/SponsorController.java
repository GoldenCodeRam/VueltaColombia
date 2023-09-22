package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.entity.Sponsor;
import com.uptc.VueltaColombia.repository.SponsorRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/sponsor/")
public class SponsorController {
    private static final Logger log = LoggerFactory.getLogger(SponsorController.class);
    @Autowired
    private SponsorRepository repository;

    @GetMapping("/find")
    public Optional<Sponsor> find(@RequestParam Long id) {
        log.info("Request to find");
        return repository.findById(id);
    }

    @PostMapping("/store")
    public void store(@Valid @RequestBody Sponsor object) {
        log.info("Request to store: \n{}", object);
        repository.save(object);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody Sponsor object) {
        log.info("Request to update: \n{}", object);
        repository
            .findById(object.getNit())
            .ifPresentOrElse(
                foundObject -> repository.save(object),
                () -> log.error("Request to update not-found: \n{}", object)
            );
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        log.info("Request to delete object: {}", id);
        repository.deleteById(id);
    }
}
