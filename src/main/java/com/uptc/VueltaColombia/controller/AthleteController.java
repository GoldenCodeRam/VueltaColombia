package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/athlete/")
public class AthleteController {
    @Autowired
    private AthleteRepository repository;

    @GetMapping("/")
    public void find(@RequestParam Long id) {
        repository.findById(id);
    }

    @PostMapping("/store/")
    public void store(@RequestBody Object object) {
        repository.save(object);
    }

    @PutMapping("/update/")
    public void update(@RequestBody Object object) {
        repository.findById(1L).ifPresent(foundObject -> {
            repository.save(object);
        });
    }

    @DeleteMapping("/delete/")
    public void delete(@RequestParam Long id) {
        repository.deleteById(id);
    }
}
