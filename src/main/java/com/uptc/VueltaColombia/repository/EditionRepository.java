package com.uptc.VueltaColombia.repository;

import com.uptc.VueltaColombia.entity.Edition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface EditionRepository extends CrudRepository<Edition, Long> {
}
