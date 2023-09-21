package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.entity.Stage;
import com.uptc.VueltaColombia.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/stage/")
public class StageController {
    @Autowired
    private StageRepository repository;

    @GetMapping("/")
    public void find(@RequestParam Long id) {
        repository.findById(id);
    }

    @PostMapping("/store/")
    public void store(@RequestBody Stage object) {
        repository.save(object);
    }

    @PutMapping("/update/")
    public void update(@RequestBody Stage object) {
        repository.findById(1L).ifPresent(foundObject -> {
            repository.save(object);
        });
    }

    @DeleteMapping("/delete/")
    public void delete(@RequestParam Long id) {
        repository.deleteById(id);
    }
}
