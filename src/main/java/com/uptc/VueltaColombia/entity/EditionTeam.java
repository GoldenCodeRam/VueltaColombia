package com.uptc.VueltaColombia.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Edition_Team")
public class EditionTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "sponsor_id")
    private Sponsor sponsor;

    @OneToMany(mappedBy = "editionTeam", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AthleteTeam> athleteTeams;

    public EditionTeam() {
    }

    public EditionTeam(Edition edition, Team team, Sponsor sponsor) {
        this.edition = edition;
        this.team = team;
        this.sponsor = sponsor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public List<AthleteTeam> getAthleteTeams() {
        return athleteTeams;
    }

    public void setAthleteTeams(List<AthleteTeam> athleteTeams) {
        this.athleteTeams = athleteTeams;
    }

    @Override
    public String toString() {
        return "EditionTeam{" +
                "id=" + id +
                ", edition=" + edition +
                ", team=" + team +
                ", sponsor=" + sponsor +
                '}';
    }
}
