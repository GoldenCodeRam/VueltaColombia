package com.uptc.VueltaColombia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Stage")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "length")
    private double length;

    @Column(name = "stage_type")
    private String stageType;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    @JsonIgnore
    private Edition edition;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Podium> podiums;

    public Stage() {
    }

    public Stage(Long id, String origin, String destination, double length, String stageType, Edition edition) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.length = length;
        this.stageType = stageType;
        this.edition = edition;
    }

    public Long getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getLength() {
        return length;
    }

    public String getStageType() {
        return stageType;
    }

    public Edition getEdition() {
        return edition;
    }

    public List<Podium> getPodiums() {
        return podiums;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", length=" + length +
                ", stageType='" + stageType + '\'' +
                ", edition=" + edition +
                ", podiums=" + podiums +
                '}';
    }
}
