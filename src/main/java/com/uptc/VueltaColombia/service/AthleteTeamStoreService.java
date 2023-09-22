package com.uptc.VueltaColombia.service;


import com.uptc.VueltaColombia.dto.AthleteTeamDTO;
import com.uptc.VueltaColombia.dto.EditionTeamDTO;
import com.uptc.VueltaColombia.entity.*;
import com.uptc.VueltaColombia.entity.key.AthleteTeamPK;
import com.uptc.VueltaColombia.entity.key.PodiumPK;
import com.uptc.VueltaColombia.repository.AthleteRepository;
import com.uptc.VueltaColombia.repository.AthleteTeamRepository;
import com.uptc.VueltaColombia.repository.EditionTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AthleteTeamStoreService {
    @Autowired
    public AthleteTeamRepository repository;
    @Autowired
    public EditionTeamRepository editionTeamRepository;
    @Autowired
    public AthleteRepository athleteRepository;

    public void store(AthleteTeamDTO dto) {
        AthleteTeam athleteTeam = this.toEditionTeam(dto);
        this.repository.save(athleteTeam);
    }

    public Optional<AthleteTeam> find(AthleteTeamDTO dto) {
        EditionTeam editionTeam = editionTeamRepository.findById(dto.editionTeamId).orElseThrow();
        Athlete athlete = athleteRepository.findById(dto.athleteId).orElseThrow();

        return repository.findById(new AthleteTeamPK(editionTeam, athlete));
    }

    public Optional<AthleteTeam> findById(Long editionTeamId, Long athleteId) {
        EditionTeam editionTeam = editionTeamRepository.findById(editionTeamId).orElseThrow();
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow();

        return repository.findById(new AthleteTeamPK(editionTeam, athlete));
    }

    public void delete(Long editionTeamId, Long athleteId) {
        EditionTeam editionTeam = editionTeamRepository.findById(editionTeamId).orElseThrow();
        Athlete athlete = athleteRepository.findById(athleteId).orElseThrow();

        repository.deleteById(new AthleteTeamPK(editionTeam, athlete));
    }

    public AthleteTeam toEditionTeam(AthleteTeamDTO dto) {
        return new AthleteTeam(
            editionTeamRepository.findById(dto.editionTeamId).orElseThrow(),
            athleteRepository.findById(dto.athleteId).orElseThrow()
        );
    }
}
