package com.uptc.VueltaColombia.dto;

import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public class PodiumDTO {
    public Long stage_id;
    public Long athlete_id;
    @NotNull
    public Integer position;
    @NotNull
    public Timestamp time;
}
