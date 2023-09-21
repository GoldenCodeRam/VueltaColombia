package com.uptc.VueltaColombia.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Edition_Team")
public class EditionTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edition_team_id_seq")
    @SequenceGenerator(name = "edition_team_id_seq", sequenceName = "edition_team_id_seq", allocationSize = 1)
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
    private List<AthleteTeam> athleteTeams;

    public EditionTeam() {
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
