package com.uptc.VueltaColombia.service;

import com.uptc.VueltaColombia.dto.StageDTO;
import com.uptc.VueltaColombia.entity.Athlete;
import com.uptc.VueltaColombia.entity.Stage;
import com.uptc.VueltaColombia.entity.key.PodiumPK;
import com.uptc.VueltaColombia.repository.EditionRepository;
import com.uptc.VueltaColombia.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StageStoreService {
    @Autowired
    public StageRepository repository;
    @Autowired
    public EditionRepository editionRepository;

    public void store(StageDTO dto) {
        Stage stage = this.toStage(dto);
        this.repository.save(stage);
    }

    public Stage toStage(StageDTO dto) {
        return new Stage(
            dto.id,
            dto.origin,
            dto.destination,
            dto.length,
            dto.stageType,
            editionRepository.findById(dto.editionId).orElseThrow()
        );
    }
}
