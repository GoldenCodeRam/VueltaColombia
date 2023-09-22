package com.uptc.VueltaColombia.repository;

import com.uptc.VueltaColombia.entity.AthleteTeam;
import com.uptc.VueltaColombia.entity.key.AthleteTeamPK;
import org.springframework.data.repository.CrudRepository;

public interface AthleteTeamRepository extends CrudRepository<AthleteTeam, AthleteTeamPK> {
}
