package com.pokemon.center.dao;

import com.pokemon.center.dao.repository.SymptomRepository;
import com.pokemon.center.persistence.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SymptomDao {
    @Autowired
    SymptomRepository symptomRepository;

    public Symptom createSymptom(Symptom symptom) {
        return symptomRepository.save(symptom);
    }

    public Symptom updateSymptom(Symptom symptom) {
        return symptomRepository.save(symptom);
    }

    public List<Symptom> findAll() {
        return symptomRepository.findAll();
    }

    public Symptom findById(int id) {
        return symptomRepository.findBySymId(id);
    }

    public List<Symptom> findByName(String symptomName) {
        return symptomRepository.findBySymNameIgnoreCaseContains(symptomName);
    }


}
