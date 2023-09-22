package com.uptc.VueltaColombia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.VueltaColombia.entity.key.AthleteTeamPK;
import jakarta.persistence.*;

@Entity
@Table(name = "Athlete_Team")
@IdClass(AthleteTeamPK.class)
public class AthleteTeam {
    @Id
    @ManyToOne
    @JoinColumn(name = "edition_team_id")
    private EditionTeam editionTeam;

    @Id
    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    public AthleteTeam() {
    }

    public AthleteTeam(EditionTeam editionTeam, Athlete athlete) {
        this.editionTeam = editionTeam;
        this.athlete = athlete;
    }

    public EditionTeam getEditionTeam() {
        return editionTeam;
    }

    public void setEditionTeam(EditionTeam editionTeam) {
        this.editionTeam = editionTeam;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @Override
    public String toString() {
        return "AthleteTeam{" +
                "editionTeam=" + editionTeam +
                ", athlete=" + athlete +
                '}';
    }
}
