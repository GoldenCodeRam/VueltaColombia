package com.uptc.VueltaColombia.repository;

import com.uptc.VueltaColombia.entity.Athlete;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends CrudRepository<Athlete, Long> {
}
