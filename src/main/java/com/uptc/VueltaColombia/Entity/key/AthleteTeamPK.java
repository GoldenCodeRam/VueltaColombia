package com.uptc.VueltaColombia.Entity.key;

import java.io.Serializable;

import com.uptc.VueltaColombia.Entity.Athlete;
import com.uptc.VueltaColombia.Entity.EditionTeam;

public class AthleteTeamPK implements Serializable {
    private EditionTeam editionTeam;
    private Athlete athlete;

    public AthleteTeamPK() {
    }

    public AthleteTeamPK(EditionTeam editionTeam, Athlete athlete) {
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
        return "AthleteTeamPK{" +
                "editionTeam=" + editionTeam +
                ", athlete=" + athlete +
                '}';
    }
}
