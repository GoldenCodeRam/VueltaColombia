package com.uptc.VueltaColombia.service;

import com.uptc.VueltaColombia.dto.EditionTeamDTO;
import com.uptc.VueltaColombia.entity.EditionTeam;
import com.uptc.VueltaColombia.repository.EditionRepository;
import com.uptc.VueltaColombia.repository.EditionTeamRepository;
import com.uptc.VueltaColombia.repository.SponsorRepository;
import com.uptc.VueltaColombia.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditionTeamStoreService {
    @Autowired
    public EditionTeamRepository repository;
    @Autowired
    private EditionRepository editionRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private SponsorRepository sponsorRepository;

    public void store(EditionTeamDTO dto) {
        EditionTeam editionTeam = this.toEditionTeam(dto);
        this.repository.save(editionTeam);
    }

    public EditionTeam toEditionTeam(EditionTeamDTO dto) {
        return new EditionTeam(
            editionRepository.findById(dto.editionId).orElseThrow(),
            teamRepository.findById(dto.teamId).orElseThrow(),
            sponsorRepository.findById(dto.sponsorId).orElseThrow()
        );
    }
}
