package com.uptc.VueltaColombia.entity.key;

import com.uptc.VueltaColombia.entity.Athlete;
import com.uptc.VueltaColombia.entity.Stage;

import java.io.Serializable;

public class PodiumPK implements Serializable {
    private Stage stage;
    private Athlete athlete;

    public PodiumPK() {
    }

    public PodiumPK(Stage stage, Athlete athlete) {
        this.stage = stage;
        this.athlete = athlete;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @Override
    public String toString() {
        return "PodiumPK{" +
                "stage=" + stage +
                ", athlete=" + athlete +
                '}';
    }
}
