package com.uptc.VueltaColombia.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_id_seq")
    @SequenceGenerator(name = "team_id_seq", sequenceName = "team_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "foundation_date")
    private Date foundationDate;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<EditionTeam> editionTeams;

    public Team() {
    }

    public Team(Long id, String name, Date foundationDate, List<EditionTeam> editionTeams) {
        this.id = id;
        this.name = name;
        this.foundationDate = foundationDate;
        this.editionTeams = editionTeams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    public List<EditionTeam> getEditionTeams() {
        return editionTeams;
    }

    public void setEditionTeams(List<EditionTeam> editionTeams) {
        this.editionTeams = editionTeams;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
