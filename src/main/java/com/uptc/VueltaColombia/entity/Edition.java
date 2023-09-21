package com.uptc.VueltaColombia.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Edition")
public class Edition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edition_id_seq")
    @SequenceGenerator(name = "edition_id_seq", sequenceName = "edition_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "year")
    private Integer year;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL)
    private List<EditionTeam> editionTeams;

    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL)
    private List<Stage> stages;

    public Edition() {
    }

    public Edition(Long id, Integer year, Date startDate, Date endDate) {
        this.id = id;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<EditionTeam> getEditionTeams() {
        return editionTeams;
    }

    public void setEditionTeams(List<EditionTeam> editionTeams) {
        this.editionTeams = editionTeams;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id=" + id +
                ", year=" + year +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
