package com.uptc.VueltaColombia.controller;

import com.uptc.VueltaColombia.entity.Stage;
import com.uptc.VueltaColombia.entity.Team;
import com.uptc.VueltaColombia.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/team/")
public class TeamController {
    @Autowired
    private TeamRepository repository;

    @GetMapping("/")
    public void find(@RequestParam Long id) {
        repository.findById(id);
    }

    @PostMapping("/store/")
    public void store(@RequestBody Team object) {
        repository.save(object);
    }

    @PutMapping("/update/")
    public void update(@RequestBody Team object) {
        repository.findById(1L).ifPresent(foundObject -> {
            repository.save(object);
        });
    }

    @DeleteMapping("/delete/")
    public void delete(@RequestParam Long id) {
        repository.deleteById(id);
    }
}
