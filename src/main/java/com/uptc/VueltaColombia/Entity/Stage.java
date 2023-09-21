package com.uptc.VueltaColombia.Entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Stage")
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stage_id_seq")
    @SequenceGenerator(name = "stage_id_seq", sequenceName = "stage_id_seq", allocationSize = 1)
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
    private Edition edition;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL)
    private List<Podium> podiums;

    public Stage() {
    }

    public Stage(Long id, String origin, String destination, double length, String stageType, Edition edition, List<Podium> podiums) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.length = length;
        this.stageType = stageType;
        this.edition = edition;
        this.podiums = podiums;
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
