package com.pokemon.center.dao.repository;

import com.pokemon.center.persistence.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SymptomRepository extends JpaRepository<Symptom, Integer>, JpaSpecificationExecutor<Symptom> {
    public Symptom findBySymId(int id);

    public List<Symptom> findBySymNameIgnoreCaseContains(String symptomNAme);
}
