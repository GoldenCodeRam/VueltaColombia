package com.uptc.VueltaColombia.Entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Sponsor")
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sponsor_nit_seq")
    @SequenceGenerator(name = "sponsor_nit_seq", sequenceName = "sponsor_nit_seq", allocationSize = 1)
    @Column(name = "NIT")
    private Long nit;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.ALL)
    private List<EditionTeam> editionTeams;

    public Sponsor() {
    }

    public Sponsor(Long nit, String name) {
        this.nit = nit;
        this.name = name;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EditionTeam> getEditionTeams() {
        return editionTeams;
    }

    public void setEditionTeams(List<EditionTeam> editionTeams) {
        this.editionTeams = editionTeams;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "nit=" + nit +
                ", name='" + name + '\'' +
                '}';
    }
}
