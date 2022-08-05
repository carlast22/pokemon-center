package com.pokemon.center.dao.repository;

import com.pokemon.center.persistence.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer>, JpaSpecificationExecutor<Treatment> {

    Treatment findTreatmentByTreId(int treatmentId);

    List<Treatment> findAllByTreNameIgnoreCaseContains(String treatmentName);
}
