package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.entity.Athlete;
import com.uptc.VueltaColombia.repository.AthleteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/athlete/")
public class AthleteController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private AthleteRepository repository;

    @GetMapping("/find")
    public void find(@RequestParam Long id) {
        repository.findById(id);
    }

    @PostMapping("/store")
    public void store(@RequestBody Athlete object) {
        repository.save(object);
    }

    @PutMapping("/update")
    public void update(@RequestBody Athlete object) {
        repository.findById(1L).ifPresent(foundObject -> {
            repository.save(object);
        });
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        repository.deleteById(id);
    }
}
