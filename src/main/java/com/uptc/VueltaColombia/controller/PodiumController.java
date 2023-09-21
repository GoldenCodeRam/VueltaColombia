package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.entity.Podium;
import com.uptc.VueltaColombia.repository.PodiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/podium/")
public class PodiumController {
    @Autowired
    private PodiumRepository repository;

    @GetMapping("/")
    public void find(@RequestParam Long id) {
        repository.findById(id);
    }

    @PostMapping("/store/")
    public void store(@RequestBody Podium object) {
        repository.save(object);
    }

    @PutMapping("/update/")
    public void update(@RequestBody Podium object) {
        repository.findById(1L).ifPresent(foundObject -> {
            repository.save(object);
        });
    }

    @DeleteMapping("/delete/")
    public void delete(@RequestParam Long id) {
        repository.deleteById(id);
    }
}
