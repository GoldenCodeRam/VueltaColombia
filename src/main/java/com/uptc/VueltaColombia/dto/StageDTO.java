package com.uptc.VueltaColombia.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class StageDTO {
    public Long id;
    @NotNull
    public String origin;
    @NotNull
    public String destination;
    @NotNull
    public Double length;
    @NotNull
    public String stageType;
    @NotNull
    public Long editionId;
}
