package com.pokemon.center.service;

import com.pokemon.center.dao.SymptomDao;
import com.pokemon.center.params.SymptomParams;
import com.pokemon.center.persistence.Symptom;
import com.pokemon.center.util.PokemonCenterResponse;
import com.pokemon.center.utilities.exceptions.PokemonCenterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService {

    @Autowired
    SymptomDao symptomDao;

    public Symptom createSymptom(SymptomParams symptomParam) {
        Symptom symptom = new Symptom();
        if (symptomParam.getName().trim().isEmpty()) {
            throw new PokemonCenterException(PokemonCenterResponse.INVALID_SYMPTOM_CREATION_PARAMS);
        }
        symptom.setSymName(symptomParam.getName().trim());
        symptom.setSymDescription(symptomParam.getDescription().trim());
        return symptomDao.createSymptom(symptom);
    }

    public Symptom updateSymptom(SymptomParams symptomParam) {
        Symptom symptom = findById(symptomParam.getId());
        if (null != symptom) {
            symptom.setSymName(symptomParam.getName());
            symptom.setSymDescription(symptomParam.getDescription());
        } else {
            throw new PokemonCenterException(PokemonCenterResponse.SYMPTOM_NOT_FOUND);
        }
        return symptomDao.updateSymptom(symptom);
    }

    public List<Symptom> findAll() {
        return symptomDao.findAll();
    }

    public Symptom findById(int id) {

        Symptom symptom = symptomDao.findById(id);
        if (null == symptom) {
            throw new PokemonCenterException(PokemonCenterResponse.SYMPTOM_NOT_FOUND);
        }

        return symptom;
    }

    public List<Symptom> findByName(String symptomName) {
        symptomName = symptomName.trim();
        return symptomDao.findByName(symptomName);
    }
}
