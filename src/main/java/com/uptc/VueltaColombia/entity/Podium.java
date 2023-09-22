package com.uptc.VueltaColombia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uptc.VueltaColombia.entity.key.PodiumPK;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Podium")
@IdClass(PodiumPK.class)
public class Podium {
    @Id
    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @Id
    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @Column(name = "position")
    private Integer position;

    @Column(name = "time")
    private Timestamp time;

    public Podium() {
    }

    public Podium(Stage stage, Athlete athlete, Integer position, Timestamp time) {
        this.stage = stage;
        this.athlete = athlete;
        this.position = position;
        this.time = time;
    }

    public Stage getStage() {
        return stage;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public Integer getPosition() {
        return position;
    }

    public Timestamp getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Podium{" +
                "stage=" + stage +
                ", position=" + position +
                ", time=" + time +
                '}';
    }
}
