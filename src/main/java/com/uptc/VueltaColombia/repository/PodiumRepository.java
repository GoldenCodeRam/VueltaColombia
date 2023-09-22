package com.uptc.VueltaColombia.repository;

import com.uptc.VueltaColombia.entity.Podium;
import com.uptc.VueltaColombia.entity.key.PodiumPK;
import org.springframework.data.repository.CrudRepository;

public interface PodiumRepository extends CrudRepository<Podium, PodiumPK> {
}
