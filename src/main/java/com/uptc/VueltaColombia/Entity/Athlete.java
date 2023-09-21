package com.uptc.VueltaColombia.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Athlete")
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "athlete_id_seq")
    @SequenceGenerator(name = "athlete_id_seq", sequenceName = "athlete_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<AthleteTeam> athleteTeams;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<Podium> athletePodiums;


    public Athlete() {
    }

    public Athlete(Long id, String name, String country, Date birthDate) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.birthDate = birthDate;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<AthleteTeam> getAthleteTeams() {
        return athleteTeams;
    }

    public void setAthleteTeams(List<AthleteTeam> athleteTeams) {
        this.athleteTeams = athleteTeams;
    }

    public List<Podium> getAthletePodiums() {
        return athletePodiums;
    }

    public void setAthletePodiums(List<Podium> athletePodiums) {
        this.athletePodiums = athletePodiums;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
