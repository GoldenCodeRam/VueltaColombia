package com.uptc.VueltaColombia.service;

import com.uptc.VueltaColombia.dto.PodiumDTO;
import com.uptc.VueltaColombia.dto.StageDTO;
import com.uptc.VueltaColombia.entity.Athlete;
import com.uptc.VueltaColombia.entity.Podium;
import com.uptc.VueltaColombia.entity.Stage;
import com.uptc.VueltaColombia.entity.key.PodiumPK;
import com.uptc.VueltaColombia.repository.AthleteRepository;
import com.uptc.VueltaColombia.repository.PodiumRepository;
import com.uptc.VueltaColombia.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PodiumStoreService {
    @Autowired
    public PodiumRepository repository;
    @Autowired
    public AthleteRepository athleteRepository;
    @Autowired
    public StageRepository stageRepository;
    public void store(PodiumDTO dto) {
        Podium podium = this.toPodium(dto);
        this.repository.save(podium);
    }

    public Optional<Podium> find(Long stageId, Long athleteId) {
        Stage stage = stageRepository.findById(stageId).orElseThrow();
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow();

        return repository.findById(new PodiumPK(stage, athlete));
    }

    public void delete(Long stageId, Long athleteId) {
        Stage stage = stageRepository.findById(stageId).orElseThrow();
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow();

        repository.deleteById(new PodiumPK(stage, athlete));
    }

    public Podium toPodium(PodiumDTO dto) {
        return new Podium(
            this.stageRepository.findById(dto.stage_id).orElseThrow(),
            this.athleteRepository.findById(dto.athlete_id).orElseThrow(),
            dto.position,
            dto.time
        );
    }
}
